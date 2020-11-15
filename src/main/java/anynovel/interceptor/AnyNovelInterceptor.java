package anynovel.interceptor;

import br.com.douglas444.dsframework.interceptor.ConsumerOrRunnableInterceptor;
import anynovel.interceptor.context.ClusteredConceptContext;

public class AnyNovelInterceptor {

    public final ConsumerOrRunnableInterceptor<ClusteredConceptContext> NOVEL_CLUSTER;
    public final ConsumerOrRunnableInterceptor<ClusteredConceptContext> KNOWN_CLUSTER;

    public AnyNovelInterceptor() {

        this.NOVEL_CLUSTER = new ConsumerOrRunnableInterceptor<>();
        this.KNOWN_CLUSTER = new ConsumerOrRunnableInterceptor<>();

    }
}
