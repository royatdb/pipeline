# Pipeline

This does not need to depend upon Apache Spark:
* Build against the `dbml-local` library at https://dl.bintray.com/databricks/maven/com/databricks/dbml-local/
* Within the application, load the saved model and make predictions.

Demo:

`sbt run`

Output:

```
[info] Running pipeline.Demo
Jul 12, 2017 12:59:04 AM com.databricks.ml.local.util.Logging$class logInfo
INFO: Importing version 0.1.1 classification.LogisticRegressionModel model with 1 rows from src/main/resources/logreg/data.
Jul 12, 2017 12:59:04 AM com.databricks.ml.local.util.Logging$class logInfo
INFO: Created a LogisticRegressionModel named logreg_c659a9ef4cf8 with 2 classes, 13 features, thresholds.size = 1.
MODEL: com.databricks.ml.local.classification.LogisticRegressionScorer@6308f7a4
INPUT:
  {
    "label":1.0,
    "features":
      {
        "type":0,
      	"size":13,
      	"indices":[0,1,2,3,4,6,7,9,10,11,12],
      	"values":[70.0,1.0,4.0,130.0,322.0,2.0,109.0,2.4,2.0,3.0,3.0]
      }
  }
OUTPUT: {"prediction":1.0,"label":1.0}
[success] Total time: 4 s, completed Jul 12, 2017 12:59:04 AM
```
