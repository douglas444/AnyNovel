package anynovel.interceptor.context;


import br.com.douglas444.dsframework.interceptor.Context;

import java.util.List;
import java.util.Set;

public class ClusteredConceptContext implements Context {

    private double[] targetClusterCentroid;
    private List<double[]> targetSamples;
    private List<double[]> knownClustersCentroids;
    private Runnable defaultAction;
    private Set<Double> knownLabels;

    public ClusteredConceptContext ClusteredConceptContext() {
        return this;
    }

    public Runnable getDefaultAction() {
        return defaultAction;
    }

    public ClusteredConceptContext setDefaultAction(Runnable defaultAction) {
        this.defaultAction = defaultAction;
        return this;
    }

    public double[] getTargetClusterCentroid() {
        return targetClusterCentroid;
    }

    public ClusteredConceptContext setTargetClusterCentroid(double[] targetClusterCentroid) {
        this.targetClusterCentroid = targetClusterCentroid;
        return this;
    }

    public List<double[]> getTargetSamples() {
        return targetSamples;
    }

    public ClusteredConceptContext setTargetSamples(List<double[]> targetSamples) {
        this.targetSamples = targetSamples;
        return this;
    }

    public List<double[]> getKnownClustersCentroids() {
        return knownClustersCentroids;
    }

    public ClusteredConceptContext setKnownClustersCentroids(List<double[]> knownClustersCentroids) {
        this.knownClustersCentroids = knownClustersCentroids;
        return this;
    }

    public Set<Double> getKnownLabels() {
        return knownLabels;
    }

    public ClusteredConceptContext setKnownLabels(Set<Double> knownLabels) {
        this.knownLabels = knownLabels;
        return this;
    }
}
