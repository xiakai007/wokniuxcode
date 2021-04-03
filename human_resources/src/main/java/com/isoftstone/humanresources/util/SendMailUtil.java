package com.isoftstone.humanresources.util;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * add by wangchun 98228 on 2019-06-17
 * 邮件发送公共方法类
 */
public class SendMailUtil {
    private static Logger logger = LoggerFactory.getLogger(SendMailUtil.class);
    // MIME邮件对象
    private MimeMessage mimeMsg;
    // 邮件会话对象
    private Session session;
    // 系统属性
    private Properties props;

    // Multipart对象,邮件内容,标题,附件等内容均添加到其中后再生成MimeMessage对象
    private Multipart mp;

    // smtp认证用户名和密码
    private String username;
    private String password;

    /**
     * Constructor
     * <p>
     * 邮件发送服务器
     */
    public SendMailUtil(String smtp,String from,String username,String password) {
        setSmtpHost(smtp);
        createMimeMessage();
    }

    /**
     * 设置邮件发送服务器
     *
     * @param hostName String
     */
    public void setSmtpHost(String hostName) {
        logger.info("设置系统属性：mail.smtp.host = " + hostName);
        // 获得系统属性对象
        if (props == null) {
            props = System.getProperties();
        }
        // 设置SMTP主机
        props.put("mail.smtp.host", hostName);
    }

    /**
     * 创建MIME邮件对象
     *
     * @return
     */
    public boolean createMimeMessage() {
        try {
            logger.info("准备获取邮件会话对象！");
            // 获得邮件会话对象
            session = Session.getInstance(props, null);

        } catch (Exception e) {
            logger.error("获取邮件会话对象时发生错误！" + e);
            return false;
        }

        logger.info("准备创建MIME邮件对象！");
        try {
            // 创建MIME邮件对象
            mimeMsg = new MimeMessage(session);
            mp = new MimeMultipart();

            return true;
        } catch (Exception e) {
            logger.error("创建MIME邮件对象失败！" + e);
            return false;
        }
    }

    /**
     * 设置SMTP是否需要验证
     *
     * @param need
     */
    public void setNeedAuth(boolean need) {
        logger.info("设置smtp身份认证：mail.smtp.auth = " + need);
        if (props == null) {
            props = System.getProperties();
        }
        if (need) {
            props.put("mail.smtp.auth", "true");
            //props.put("mail.smtp.port", "465");
        } else {
            props.put("mail.smtp.auth", "false");
        }
    }
    /**
     * 设置用户名和密码
     *
     * @param name
     * @param pass
     */
    public void setNamePass(String name, String pass) {
        username = name;
       //password = MD5.getMD5Code(pass);
       password =pass;


    }


    /**
     * 设置邮件主题
     *
     * @param mailSubject
     * @return
     */
    public boolean setSubject(String mailSubject) {
        logger.info("设置邮件主题！");
        try {
            mimeMsg.setSubject(mailSubject);
            return true;
        } catch (Exception e) {
            logger.error("设置邮件主题发生错误！");
            return false;
        }
    }

    /**
     * 设置邮件正文
     *
     * @param mailBody String
     */
    public boolean setBody(String mailBody) {
        try {
            BodyPart bp = new MimeBodyPart();
            bp.setContent("" + mailBody, "text/html;charset=GBK");
            mp.addBodyPart(bp);

            return true;
        } catch (Exception e) {
            logger.error("设置邮件正文时发生错误！" + e);
            return false;
        }
    }

    /**
     * 添加附件
     *
     * @param filename String
     */
    public boolean addFileAffix(String filename) {

        logger.info("增加邮件附件：" + filename);
        try {
            BodyPart bp = new MimeBodyPart();
            FileDataSource fileds = new FileDataSource(filename);
            bp.setDataHandler(new DataHandler(fileds));
            bp.setFileName(MimeUtility.encodeText(fileds.getName()));

            mp.addBodyPart(bp);

            return true;
        } catch (Exception e) {
            logger.error("增加邮件附件：" + filename + "发生错误！" + e);
            return false;
        }
    }

    /**
     * 设置发信人
     *
     * @param from String
     */
    public boolean setFrom(String from) {
        logger.info("设置发信人！");
        try {
            mimeMsg.setFrom(new InternetAddress(from,"MAG华为综合业务事业本部","UTF-8")); // 设置发信人
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 设置收信人
     *
     * @param to String
     */
    public boolean setTo(String to) {
        if (to == null) {
            return false;
        }
        try {
            String[] toArray = to.split(";");

            InternetAddress[] total = new InternetAddress[toArray.length];
            for (int i = 0; i < toArray.length; i++) {
                total[i] = new InternetAddress(toArray[i].trim());
            }
            mimeMsg.setRecipients(Message.RecipientType.TO, total);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 设置抄送人
     *
     * @param copyto String
     */
    public boolean setCopyTo(String copyto) {
        if (copyto == null || copyto.equals("")) {
            logger.error("无抄送。。。");
            return true;
        }
        try {
            String[] toArray = copyto.split(";");

            InternetAddress[] total = new InternetAddress[toArray.length];
            for (int i = 0; i < toArray.length; i++) {
                total[i] = new InternetAddress(toArray[i].trim());
            }
            mimeMsg.setRecipients(Message.RecipientType.CC, total);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 发送邮件
     */
    public boolean sendOut() {
        try {
            mimeMsg.setContent(mp);
            mimeMsg.saveChanges();
            logger.info("正在发送邮件....");

            Session mailSession = Session.getInstance(props, null);
            Transport transport = mailSession.getTransport("smtp");
            transport.connect((String) props.get("mail.smtp.host"),username, password);
            transport.sendMessage(mimeMsg, mimeMsg.getRecipients(Message.RecipientType.TO));

            logger.info("发送邮件成功！");
            transport.close();

            return true;
        } catch (Exception e) {
            logger.error("邮件发送失败！" + e.getMessage());
            return false;
        }
    }

    /**
     * 发送邮件
     */
    public boolean sendOutToCC() {
        try {
            mimeMsg.setContent(mp);
            mimeMsg.saveChanges();
            logger.info("正在发送邮件....");

            Session mailSession = Session.getInstance(props, null);
            Transport transport = mailSession.getTransport("smtp");
            transport.connect((String) props.get("mail.smtp.host"), username, password);
            transport.sendMessage(mimeMsg, mimeMsg.getRecipients(Message.RecipientType.TO));
            transport.sendMessage(mimeMsg, mimeMsg.getRecipients(Message.RecipientType.CC));
            // transport.send(mimeMsg);

            logger.info("发送邮件成功！");
            transport.close();

            return true;
        } catch (Exception e) {
            logger.error("邮件发送失败！" + e);
            return false;
        }
    }

    /**
     * 调用sendOut方法完成邮件发送
     *
     * @param to
     * @param subject
     * @param content
     * @return boolean
     */
    public static boolean send(String smtp, String from, String to, String subject, String content, String username,
                               String password) {
        logger.info("-"+smtp+"-"+from+"-"+to+"-"+subject+"-"+content+"-"+username+"-"+password+"-");
        SendMailUtil theMail = new SendMailUtil(smtp,from,username,password);
        theMail.setNeedAuth(true); // 需要验证

        if (!theMail.setSubject(subject)) {
            return false;
        }
        if (!theMail.setBody(content)) {
            return false;
        }
        if (!theMail.setTo(to)) {
            return false;
        }
        if (!theMail.setFrom(from))
        {
            return false;
        }
        theMail.setNamePass(username, password);
        if (!theMail.sendOut()) {
            return false;
        }
        return true;
    }

    /**
     * 调用sendOut方法完成邮件发送,带抄送
     *
     * @param to
     * @param copyto
     * @param subject
     * @param content
     * @return boolean
     */
    public static boolean sendAndCc(String smtp, String from, String to, String copyto, String subject, String content,
                                    String username, String password) {
        SendMailUtil theMail = new SendMailUtil(smtp,from,username,password);
        theMail.setNeedAuth(true); // 需要验证

        if (!theMail.setSubject(subject)) {
            return false;
        }
        if (!theMail.setBody(content)) {
            return false;
        }
        if (!theMail.setTo(to)) {
            return false;
        }
        if (!theMail.setCopyTo(copyto)) {
            return false;
        }
        if (!theMail.setFrom(from))
        {
            return false;
        }
        theMail.setNamePass(username, password);
        if (!theMail.sendOutToCC()) {
            return false;
        }
        return true;
    }

    /**
     * 调用sendOut方法完成邮件发送,带附件
     *
     * @param to
     * @param subject
     * @param content
     * @param filename 附件路径
     * @return
     */
    public static boolean sendCarryFile(String smtp, String from, String to, String subject, String content, String username,
                                        String password, String filename) {
        SendMailUtil theMail = new SendMailUtil(smtp,from,username,password);
        theMail.setNeedAuth(true); // 需要验证
        if (!theMail.setSubject(subject)) {
            return false;
        }
        if (!theMail.setBody(content)) {
            return false;
        }
        if (!theMail.addFileAffix(filename)) {
            return false;
        }
        if (!theMail.setTo(to)) {
            return false;
        }
        if (!theMail.setFrom(from))
        {
            return false;
        }
        theMail.setNamePass(username, password);
        if (!theMail.sendOut()) {
            return false;
        }
        return true;
    }

    /**
     * 调用sendOut方法完成邮件发送,带附件和抄送
     *
     * @param to
     * @param copyto
     * @param subject
     * @param content
     * @param filename
     * @return
     */
    public static boolean sendAndCcCarryFile(String smtp, String from, String to, String copyto, String subject, String content,
                                             String username, String password, String filename){
        SendMailUtil theMail = new SendMailUtil(smtp,from,username,password);
        theMail.setNeedAuth(true); // 需要验证
        if (!theMail.setSubject(subject)) {
            return false;
        }
        if (!theMail.setBody(content)) {
            return false;
        }
        if (!theMail.addFileAffix(filename)) {
            return false;
        }
        if (!theMail.setTo(to)) {
            return false;
        }
        if (!theMail.setCopyTo(copyto)) return false;
        if (!theMail.setFrom(from))
        {
            return false;
        }
        theMail.setNamePass(username, password);

        if (!theMail.sendOutToCC()) return false;
        return true;
    }

}
