package com.wee.voyages;

import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.MatchResult;

/**
 * User: weejulius
 * Date: 2009-7-30
 * Time: 19:28:30
 */
public class RegexGroup{
    private Logger log= LoggerFactory.getLogger(this.getClass());
    @Test
    public void validate(){
        String[] urls={"","/","/new","/123","/123action=start"};
        for(String url:urls){
         String patternStr="(?:/(\\d+)(?:action=((?:start)|(?:end)))?)|(?:/(new))|(?:/)";
        Pattern pattern=Pattern.compile(patternStr);
        Matcher matcher=pattern.matcher(url);
        if(matcher.find()){
           log.debug("url:{}:",url);
            notNullCount(matcher);
        }else{
            log.debug("no matchers");
        }
        }

    }

    private int notNullCount(Matcher matcher) {
        int result=0;
        for(int i=0;i<=matcher.groupCount();i++){
            String match=matcher.group(i);
            if(match!=null){
            log.debug("url matcher:{}",match);
            }
        }
        return result;
    }

    @Test
    public void replace(){
        String str="/(\\d+)";
        Pattern pattern=Pattern.compile(str);
       // Matcher matcher=pattern.matcher(str);
        String[] strs={"/1/end","/voyages/aab/start","/voyages/start","/voyages/1","/voyages123/start","voyages/4/starts"};
       for(String s:strs){
           Matcher matcher=pattern.matcher(s);
           if(matcher.find()){
              for(int i=1;i<=matcher.groupCount();i++){
                  log.debug("group {} is {}",i,matcher.group(i));
              }
           }

       }


    }
}
