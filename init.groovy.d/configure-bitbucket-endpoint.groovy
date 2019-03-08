import jenkins.model.Jenkins
import com.cloudbees.jenkins.plugins.bitbucket.endpoints.*

instance = Jenkins.getInstance()
bitbucketDescriptor = instance.getDescriptor("com.cloudbees.jenkins.plugins.bitbucket.endpoints.BitbucketEndpointConfiguration")

println "Setting BitBucket endpoint..."
AbstractBitbucketEndpoint newEndpoint = new BitbucketServerEndpoint(
  "My BitBucket",                     // Name
  "https://mybitbucket.example.com",  // URL
  false,                              // Manage Hooks (boolean)
  "my-bitbucket-creds"                // Credentials ID (string)
)

newEndpoint.setCallCanMerge(false)
bitbucketDescriptor.updateEndpoint((AbstractBitbucketEndpoint)newEndpoint)
instance.save()
