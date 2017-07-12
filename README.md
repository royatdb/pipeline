# Pipeline

This does not need to depend upon Apache Spark:
* Build against the `dbml-local` library at https://dl.bintray.com/databricks/maven/com/databricks/dbml-local/
* Within the application, load the saved model and make predictions.

Benchmark:

`sbt "jmh:run -i 5 -wi 5 -f1 -t1 DemoBenchmark.*"`

Output:

```
[info] Running org.openjdk.jmh.Main -i 5 -wi 5 -f1 -t1 DemoBenchmark.*
[info] # JMH version: 1.19
[info] # VM version: JDK 1.8.0_131, VM 25.131-b11
[info] # VM invoker: /Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/jre/bin/java
[info] # VM options: none
[info] # Warmup: 5 iterations, 1 s each
[info] # Measurement: 5 iterations, 1 s each
[info] # Timeout: 10 min per iteration
[info] # Threads: 1 thread, will synchronize iterations
[info] # Benchmark mode: Throughput, ops/time
[info] # Benchmark: pipeline.DemoBenchmark.transform
[info]
[info] # Run progress: 0.00% complete, ETA 00:00:10
[info] # Fork: 1 of 1
[error] Jul 12, 2017 12:55:11 AM com.databricks.ml.local.util.Logging$class logInfo
[error] INFO: Importing version 0.1.1 classification.LogisticRegressionModel model with 1 rows from src/main/resources/logreg/data.
[error] Jul 12, 2017 12:55:11 AM com.databricks.ml.local.util.Logging$class logInfo
[error] INFO: Created a LogisticRegressionModel named logreg_c659a9ef4cf8 with 2 classes, 13 features, thresholds.size = 1.
[info] # Warmup Iteration   1: 13693.560 ops/s
[info] # Warmup Iteration   2: 64141.838 ops/s
[info] # Warmup Iteration   3: 85106.191 ops/s
[info] # Warmup Iteration   4: 110518.672 ops/s
[info] # Warmup Iteration   5: 118478.866 ops/s
[info] Iteration   1: 118672.739 ops/s
[info] Iteration   2: 119767.435 ops/s
[info] Iteration   3: 119796.169 ops/s
[info] Iteration   4: 119579.911 ops/s
[info] Iteration   5: 116641.256 ops/s
[info]
[info]
[info] Result "pipeline.DemoBenchmark.transform":
[info]   118891.502 ±(99.9%) 5155.785 ops/s [Average]
[info]   (min, avg, max) = (116641.256, 118891.502, 119796.169), stdev = 1338.941
[info]   CI (99.9%): [113735.717, 124047.287]	(assumes normal distribution)
[info]
[info]
[info] # Run complete. Total time: 00:00:11
[info]
[info] Benchmark                 Mode  Cnt       Score      Error  Units
[info] DemoBenchmark.transform  thrpt    5  118891.502 ± 5155.785  ops/s
```
