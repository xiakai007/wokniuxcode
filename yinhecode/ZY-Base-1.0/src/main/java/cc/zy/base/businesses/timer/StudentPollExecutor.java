package cc.zy.base.businesses.timer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**

 * @author zhangkai
 * @date 2021-02-01 10:55:03
 */
public class StudentPollExecutor {

    private ThreadPoolExecutor poolExecutor;

    private  StudentPollExecutor(){
        poolExecutor=new ThreadPoolExecutor(10,20,
                0L, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(20),
                Executors.defaultThreadFactory());
    }

    private  static  StudentPollExecutor  studentPollExecutor;

    public  static  StudentPollExecutor  getStudentPollExecutor(){
        if (studentPollExecutor==null){
            studentPollExecutor=new StudentPollExecutor();
        }
        return   studentPollExecutor;
    }


    public   ThreadPoolExecutor   getThreadPoolExecutor(){
        return poolExecutor;
    }

}
