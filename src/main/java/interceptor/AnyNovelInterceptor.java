package interceptor;

import br.com.douglas444.dsframework.interceptor.ConsumerOrRunnableInterceptor;
import interceptor.context.ClusteredConceptContext;

public class AnyNovelInterceptor {

    public final ConsumerOrRunnableInterceptor<ClusteredConceptContext> NOVELTY_SEGMENT;
    public final ConsumerOrRunnableInterceptor<ClusteredConceptContext> KNOWN_SEGMENT;

    public AnyNovelInterceptor() {

        this.NOVELTY_SEGMENT = new ConsumerOrRunnableInterceptor<>();
        this.KNOWN_SEGMENT = new ConsumerOrRunnableInterceptor<>();

    }
}
