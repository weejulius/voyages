package com.wee.mvc;

import com.google.inject.internal.Sets;
import com.wee.voyages.application.validatation.Objects;
import com.wee.voyages.application.validatation.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: weejulius
 * Date: 2009-7-28
 * Time: 20:26:19
 */
public class URLPattern {

    private Pattern pattern;
    private Logger log = LoggerFactory.getLogger(this.getClass());

    public URLPattern(String regex){
        pattern = Pattern.compile(regex);

    }

    public boolean match(String str) {
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public Set<String> getActionByURL(String url) {
        Matcher matcher = pattern.matcher(url);
        if (matcher.matches()) {
            return matchElements(matcher, url);
        }
        return Objects.failedInstance();
    }

    private Set<String> matchElements(Matcher matcher, String url) {
        Set<String> elements = Sets.newHashSet();
        for (int i = 0; i <= matcher.groupCount(); i++) {
            String el = matcher.group(i);
            if (Strings.notNull(el) && !el.equals(url)) {
                elements.add(el);
            }
        }
        return elements;
    }
}
