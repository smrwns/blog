package com.smrwns.config.Interceptor;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.web.ConnectInterceptor;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.WebRequest;

public class TweetAfterConnectInterceptor implements ConnectInterceptor<Twitter> {

    @Override
    public void preConnect(ConnectionFactory<Twitter> connectionFactory, MultiValueMap<String, String> parameters, WebRequest request) {
        if(StringUtils.hasText(request.getParameter(POST_TWEET_PARAMETER)))
            request.setAttribute(POST_TWEET_ATTRIBUTE, Boolean.TRUE, WebRequest.SCOPE_SESSION);
    }

    @Override
    public void postConnect(Connection<Twitter> connection, WebRequest request) {
        if(request.getAttribute(POST_TWEET_ATTRIBUTE, WebRequest.SCOPE_SESSION) != null) {
            connection.updateStatus("소셜 연결이 성공적으로 진행되었었음.");
            request.removeAttribute(POST_TWEET_ATTRIBUTE, WebRequest.SCOPE_SESSION);
        }
    }

    private static final String POST_TWEET_PARAMETER = "postTweet";
    private static final String POST_TWEET_ATTRIBUTE = "tweetConnect." + POST_TWEET_PARAMETER;
}