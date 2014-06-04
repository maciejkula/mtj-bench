package com.github.maciejkula.mtjbench;

import no.uib.cipr.matrix.DenseVector;
import no.uib.cipr.matrix.Vector;
import no.uib.cipr.matrix.sparse.SparseVector;
import org.openjdk.jmh.annotations.*;

/**
 * Created by maciej on 04/06/14.
 */
@State(Scope.Thread)
public class VectorBenchmark {

    Vector xDense;
    Vector yDense;

    Vector xSparse;
    Vector ySparse;

    @Setup(Level.Iteration)
    public void prepare() {
        double[] x = {0.0, 1.0, 3.4, 15.2, 0.0, 0.0, 16.7, 0.0};
        double[] y = {1.0, 2.3, 4.4, -3.2, 0.0, 1.3, 10.2, -4.0};

        this.xDense = new DenseVector(x);
        this.yDense = new DenseVector(y);

        this.xSparse = new SparseVector(xDense);
        this.ySparse = new SparseVector(yDense);
    }

    @GenerateMicroBenchmark
    public void testDenseDenseDot() {
        xDense.dot(yDense);
    }

    @GenerateMicroBenchmark
    public void testSparseSparseDot() {
        xSparse.dot(ySparse);
    }

    @GenerateMicroBenchmark
    public void testDenseSparseDot() {
        xDense.dot(ySparse);
    }

    @GenerateMicroBenchmark
    public void testSparseDenseDot() {
        xSparse.dot(yDense);
    }

    @GenerateMicroBenchmark
    public void testDenseDenseMult() {
        xDense.mult(yDense);
    }

    @GenerateMicroBenchmark
    public void testSparseDenseMult() {
        xSparse.mult(yDense);
    }

    @GenerateMicroBenchmark
    public void testDenseSparseMult() {
        xDense.mult(ySparse);
    }

    @GenerateMicroBenchmark
    public void testSparseSparseMult() {
        xSparse.mult(ySparse);
    }
}
