package webhook.teamcity.auth.chatwork;

import webhook.teamcity.auth.AbstractWebHookAuthenticatorFactory;
import webhook.teamcity.auth.WebHookAuthenticationParameter;
import webhook.teamcity.auth.WebHookAuthenticator;
import webhook.teamcity.auth.WebHookAuthenticatorFactory;
import webhook.teamcity.auth.WebHookAuthenticatorProvider;

public class ChatworkAuthenticatorFactory extends AbstractWebHookAuthenticatorFactory implements WebHookAuthenticatorFactory{

		public ChatworkAuthenticatorFactory(WebHookAuthenticatorProvider provider) {
			super(provider);
			parameterDefinition.add(
					new WebHookAuthenticationParameter(ChatworkAuthenticator.KEY_CW_TOKEN, REQUIRED, NOT_HIDDEN, "Chatwork API Token", "The API token that the webhook should send to authenticate with the webserver.")
			);
		}
		
		@Override
		public String getName() {
			return "chatwork";
		}
		
		@Override
		public String getDescription() {
			return "Chatwork Authentication";
		}

		@Override
		public WebHookAuthenticator getAuthenticatorInstance() {
			return new ChatworkAuthenticator();
		}

}

