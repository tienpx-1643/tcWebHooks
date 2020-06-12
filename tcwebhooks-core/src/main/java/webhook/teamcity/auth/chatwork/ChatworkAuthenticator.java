package webhook.teamcity.auth.chatwork;

import java.net.URI;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.client.methods.HttpPost;

import webhook.teamcity.auth.AbstractWebHookAuthenticator;
import webhook.teamcity.auth.WebHookAuthenticator;

public class ChatworkAuthenticator extends AbstractWebHookAuthenticator implements WebHookAuthenticator {

		public static final String KEY_CW_TOKEN = "chatwork_token";
		
		@Override
		public void addAuthentication(CredentialsProvider credentialsProvider, HttpClientContext httpClientContext, String url, HttpPost httppost) {
			if (config.getParameters().containsKey(KEY_CW_TOKEN)){
                httppost.addHeader("X-ChatWorkToken", config.getParameters().get(KEY_CW_TOKEN));
			}
		}

		@Override
		public String getWwwAuthenticateChallengePrefix() {
			return "chatwork";
		}

}

