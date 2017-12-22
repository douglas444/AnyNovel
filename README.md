# AnyNovel
Setup and commandas
--------------------------
For training and building the model only, Run TrainingLauncher. To train the model using a given labelled instances please use the following command 
- BLM train "file_name_including_ext" or "name of teh dataset" 
TraingingLaucher is an offline process and may take time to build the BLM which will be used later by anyNovel. The model is stored in Models folder and can be used directly by AnyNovel in the online/streaming environment. 

- BLM : takes two parameters: 
1- train or load (please note "load" runs only through ExpLauncher, if you run TrainingLauncher only train option is valid)

2- dataset name or exact file name, that is located in "Data" folder, including extenstion 

train command: takes either:

1- "File_name"
Builds model using the provided training data. 
Accepts both CSV and ARFF files. 
The provided file is inside /Data/Train/"file name"."CSV or ARFF"
The given file contains data to build the Baseline Model (BLM). It has to contain only existing concepts and no instances of the novel concept, which will only be provided in testing/streaming data for detecting the novel concept. 
Example: -BLM train iris_virgincia_versicolor.arff to directrly choose the file. The file is located into the data folder. 


2- "Dataset name"
If you are not sure about the file, you can just write the dataset name and a prompot will apppear to choose from the different related files that exist in this path. 

example: -BLM train iris, will trigger a prompt that inquries about possible datafile to run


For both options: 
The output model is stored in /Models/"dataset_name"_"names of existing concepts".dat
Example: Iris dataset that contains only virgincia and versiolor is stored in the Models folder with name: Iris_vergincia_versicolor.dat

**** Advanced: 
-clust argument for specifying the clustering method applied to generate sub-clusters inside each cluster to build BLM. The default is EM method with 3 sub-clusters for each cluster. 

To change this: 
-BLM train iris clust EM -N 5 (EM for 5 clusters)
-BLM train iris clust Kmeans -N 6 (using kmeeans for 6 clusters )
-BLM train iris -clust EM -N -1 (unspecific number of cluster for each cluster)


------------
For training followed by running AnyNovel, run ExpLauncher 
parameters are: -BLM train/ load "dataest"  -test "file_name_including_ext_for_test"
** load "file name"
to load an existing model which is stored in /Models/"dataset_name"_"Existing classes".dat
** Dataset name is entered via prompt. 
The data is parsed and ready for any model . 

The only paramater for load is the file name with extension and this should be in the Models folder. 
Example -BLM load iris_Iris-setosa_Iris-versicolor.dat
example: 
- BLM train iris_train.arff -test iris_test.arff
iris_train in Train data folder, iris test in Data/Test/ folder
-----------

Parameters: 

Setup: 

- Segment_Size: No of points in each chunk of data in the stream. Each segnemt will be clustered into 2 clusters for capturating iterrleaved and overlapped conceprs 
- Slacks: Each concept has a slack around that decides on the concept boundries. This number is either constant for all constants or different for each concept (differerent concepts can be sepereated by commas (S1,S2,S3, ..Sn) where n is the number of existing concepts, Si is the slack size of cocept i (in the same order as per BLM))

Stability conditions: 

- Movement: Centre movement threshold for stability conditions of novel concept. 
- Novel_Slack: the novel concept slack size (when emerged)
- Stable_Size: min no of points that are required to fullfil the stability conditions of novel concept 
- Away_Threshold: a threshold for monitoring the movement of a concept (when the movement exceddes the threshold, it is considered as away movement

Flags: 

- Buffer_Flag = True if there is a constraint on the buffer size (cannot be too big). Otherwise, the buffer will be acculamted, regardless of the size, till declare one of the three decisions; buffer instances are existing concept, new concept or unknow. 
- JP_Layer= True if monitoring the correlation between the just predicted concepts and new points in the stream. JP is either existing, novel or unknow. JP gives more weight to the prior that belongs to the previous JP decision. 
- Update_Flag: Activate automatic incremental and active learning
- Validate_Flag: activate incremenetal and active learning in case of Fp and Fn (if validation data is provided), throws an error if True and no validation file is provided [still under development]

All parameters are located in the parameters text file in the root path. 

Templates of best practice for different datasets exist in parameters examples folder

Datafiles Setup for anyNovel: 
In order to prepare datasets for any novel, we split data into training and testing: 
- Training data: Remove target new class(es) from the dataseet, Split data to 50 % training and 50% testing for exising concepts. These precentages could be changed. 
- Test: on the entire dataset including new concept(s)

Example: 

Train/Iris_sentosa.arff: Contains training data for sentosa class only 
Test/Iris.arff: Contains tets data for exiisting and new concepts. 

PS. the focus of AnyNovel is for detecting novel concepts instaed of classifying/distinguishing between existing once. Therefore, prediction accuracy and confusion matrix for existing classes are for guidance only. 
 

EXxpLauncher>> AntNovelLaouncher.Run (>> AntNovelLaouncher. runOnData (BLM, Test Data) >>AnyNovel 
9BLM, test data, parameters) >> ACTION FUNCTION BLM. AdaptationComponent (streamSegment) 
