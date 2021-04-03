package cc.zy.base.common.paymentUtils.example_JinJian;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import cc.zy.base.common.paymentUtils.constant.ComConstant_JinJian;
import cc.zy.base.common.paymentUtils.util.SignUtil;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;


/**
 * 进件--上传图片
 * Created by LVHUIHUI on 2018-9-4
 *
 */
public class FrontUpload {
	/**
	 * 组装请求参数
	 * @return
	 */
	public static Map getReqparas(){
		    String filePath = "G:/进件资料_01.jpg";
	        Map<String,String> postParam = new HashMap<String,String>();
			HashMap<String, String> head = new HashMap<String, String>();
			HashMap<String, String> body = new HashMap<String, String>();
			HashMap<String, HashMap<String, String>> requestJson = new HashMap<String, HashMap<String, String>>();
			HashMap<String,String> map = new HashMap<String,String>();
			head.put("service", "common.upload");//上传图片方法名
	        head.put("version", "1.0");//默认版本号
	        head.put("input_charset", ComConstant_JinJian.INPUT_CHARSET);//编码格式，默认只支持UTF-8
	        head.put("channel_partner_id",ComConstant_JinJian.CHANNEL_PARTNER_ID );//联富通渠道合作编号(开通代理商账号时，联富通商务提供) 
	        head.put("platform_merchant_no", ComConstant_JinJian.PLATFORM_MERCHANT_NO);//联富通平台商户编号(开通代理商账号时，联富通商务提供) 
	        //业务
	        body.put("out_request_no", "linzz" + System.currentTimeMillis());//商户请求图片编号
	        body.put("picture_type", "01");//图片类型
	        
	        requestJson.put("head", head);
	        requestJson.put("body", body);
	        map.putAll(head);
	        map.putAll(body);
	        String sign = SignUtil.createSign(map, ComConstant_JinJian.PARTER_KEY,ComConstant_JinJian.INPUT_CHARSET);
	  
	        head.put("sign", sign);
	        head.put("sign_type", ComConstant_JinJian.SIGN_TYPE);
	        postParam.put("requestJson",  JSON.toJSONString(requestJson));
	        System.out.println("请求参数==="+postParam.toString());
	        
	        File postFile = new File(filePath);
	       
	        Map<String,Object> resultMap = new HashMap<String,Object>();
	        CloseableHttpClient httpClient = HttpClients.createDefault();
	        try{
	            //把一个普通参数和文件上传给下面这个地址    是一个servlet
	            HttpPost httpPost = new HttpPost(ComConstant_JinJian.SERVICEURL_NEWFRONT);
	            //把文件转换成流对象FileBody
	            FileBody fundFileBin = new FileBody(postFile);
	            //设置传输参数
	            MultipartEntityBuilder multipartEntity = MultipartEntityBuilder.create();
	            multipartEntity.addPart(postFile.getName(), fundFileBin);//相当于<input type="file" name="media"/>
	            //设计文件以外的参数
	            Set<String> keySet = postParam.keySet();
	            for (String key : keySet) {
	                //相当于<input type="text" name="name" value=name>
	                multipartEntity.addPart(key, new StringBody(postParam.get(key), ContentType.create("text/plain", Consts.UTF_8)));
	            }

	            HttpEntity reqEntity =  multipartEntity.build();
	            httpPost.setEntity(reqEntity);

	            System.out.println("发起请求的页面地址 " + httpPost.getRequestLine());
	            //发起请求   并返回请求的响应
	            CloseableHttpResponse response = httpClient.execute(httpPost);
	            try {
	                //打印响应状态
	                resultMap.put("statusCode", response.getStatusLine().getStatusCode());
	                //获取响应对象
	                HttpEntity resEntity = response.getEntity();
	                if (resEntity != null) {
	                    //打印响应长度
	                    System.out.println("Response content length: " + resEntity.getContentLength());
	                    //打印响应内容
	                    String result = EntityUtils.toString(resEntity,Charset.forName("UTF-8"));
	                    resultMap.put("data", result);
	                    System.out.println("进件--上传图片===服务器端返回res" + result);
	                }
	                //销毁
	                EntityUtils.consume(resEntity);
	            } catch (Exception e) {
	                e.printStackTrace();
	            } finally {
	                response.close();
	            }
	        } catch (ClientProtocolException e1) {
	            e1.printStackTrace();
	        } catch (IOException e1) {
	            e1.printStackTrace();
	        } finally{
	            try {
	                httpClient.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        return resultMap;
   }
	//01_153604766770181170967367256289.jpg
	public static void main(String[] args)  { 
		getReqparas();
	}
}
