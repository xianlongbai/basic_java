package com.jenkins;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by root on 2019/6/3.
 */
public class Test {


    public static void main(String[] args) throws URISyntaxException, IOException {

        JenkinsServer jenkins = new JenkinsServer(new URI("http://192.168.249.140:8080/jenkins"), "admin", "admin");
//        JenkinsServer jenkins = new JenkinsServer(new URI("http://jk.tendcloud.com/job/haina/"), "xianlong.bai", "52930b28e78abcb3cca2925149a46362");
        //参数任务
        JobWithDetails job = jenkins.getJob("sqoop_job");
        Map<String,String> param = new HashMap();

        param.put("token","1189538c1efbdff8483d7134af6ce70498");
        param.put("hdfspath","/user/root/sqoop/data009");
        param.put("username","root");
        param.put("password","root");
        param.put("host","172.30.105.234");
        param.put("port","3306");
        param.put("dbname","tags_auto");
        param.put("tablename","type_20190405");
        param.put("delimiter","\\001");
        param.put("tasksize","2");
        param.put("splitby","name");
        param.put("fileformat","textfile");


        job.build(param,true);


//        param.put("userName","zhaobenshan");
//        param.put("cause","end");

//        Build build = job.getBuildByNumber(15);


        //QueueReference build = job.build();
//        String queueItemUrlPart = build.getQueueItemUrlPart();
//        Build lastBuild = job.getLastBuild();
//        int number1 = lastBuild.getNumber();
//        Build lastCompletedBuild = job.getLastCompletedBuild();
//        int number2 = lastCompletedBuild.getNumber();
//
//        System.out.println(number1==number2);

//        int jobId = job.getNextBuildNumber();
//        System.out.println("--->:"+jobId);
//        Build lastUnstableBuild = job.getLastUnstableBuild();
//        int number = lastUnstableBuild.getNumber();
//        System.out.println("--->:"+number);
//        List<Build> builds = job.getBuilds();
//        System.out.println(11);


//        Map<String,String> param = new HashMap();
//        param.put("userName","zhaobenshan");
//        param.put("cause","end");
//        param.put("token","1189538c1efbdff8483d7134af6ce70498");
//        job.build(param,true);  //第二个参数,是否需要凭证信息

//        Build build = job.getBuildByNumber(15);



//        BuildWithDetails details = build.details();
//        TestResult testResult = build.getTestResult();
//        List<BuildCause> causes = details.getCauses();
//        for (BuildCause cause : causes) {
//            System.out.println(111);
//        }

//        BuildWithDetails details = build.details();
//        List actions = details.getActions();
//        List<Artifact> artifacts = details.getArtifacts();
//        String builtOn = details.getBuiltOn();
//        BuildChangeSet changeSet = details.getChangeSet();
//        List<BuildChangeSet> changeSets = details.getChangeSets();
//        List<BuildCause> causes = details.getCauses();
//        String consoleOutputText = details.getConsoleOutputText();
//        String consoleOutputHtml = details.getConsoleOutputHtml();
//        List<BuildChangeSetAuthor> culprits = details.getCulprits();
//        String displayName = details.getDisplayName();
//        String description = details.getDescription();
//        long duration = details.getDuration();
//        long estimatedDuration = details.getEstimatedDuration();
//        String fullDisplayName = details.getFullDisplayName();
//        String id = details.getId();
//        Map<String, String> parameters = details.getParameters();
//        BuildResult result = details.getResult();
//        String resultStr = result.name();
//        long timestamp = details.getTimestamp();
//
//        String test = "";
//        String[] splits = consoleOutputText.split("\r\n");
//        for (String str : splits) {
//            if (str.contains("INFO mapreduce.ImportJobBase: Retrieved")){
//                test = str;
//            }
//        }
//
//        String[] strs = test.split(" ");
//        String rowcount = strs[strs.length-2];
//        System.out.println(rowcount);



    }


}
