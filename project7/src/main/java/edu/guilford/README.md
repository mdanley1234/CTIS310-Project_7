# CTIS 310 Programming Project 7

## Specification Requirements

Programming project 7 asks us to work with String data stored in txt files. My data object of choice will need to be able to hold a preferably dynamic number of elements. This is because I don't know how many elements my txt file with ultimately hold until the entire document has been read. The specification also requires us to sort the data in numerous ways and perform random data calls.
This makes certain data structures significantly better optimized for the task. 

## Implementation Choice
Since we need to sort our data structure of choice, a list or array would best hold an ordering of String or DataPoint objects. We also require that our data structure is dynamic to account for the unknown size of our txt file. An array fails this specification since an array must know its size before being created. This means a list implementation would be the best data structure. For these reasons, I use an ArrayList object to hold my String and DataPoint objects.