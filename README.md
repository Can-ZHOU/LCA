## LCA -- DAG [In **DAG** branch]

- **DAG Solution and its test code are in the src folder**
- LCA_DAG.java is the source code for solving the LCA problem in a Directed Acyclic Graph.

- LCA_DAG_Test.java is the JUnit test code for the methods in LCA_DAG.java

### How to run the code:
- After download, it should can be directly opened and run in Eclipse.
- However if you cannot open it, Please follow these instructions:
  - Create a new Java Project.
  - Import the above LCA_DAG.java into the project.
  - Create a new jUnit test named LCA_DAG_Test.java.
  - Replace the contents of LCA_DAG_Test.java created in Eclipse with the contents of the LCA_DAG_Test.java in src folder.
- If still cannot run them, please email to me: zhouc@tcd.ie
  
### Visualization the test cases in LCA_DAG_Test.java
- This is to make the tests I did for DAG look clearer.
- DAG with a node that does not exist in the graph.
  - DAG-0: Empty DAG
  - DAG-1: &nbsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;DAG-2:   
    $\qquad1$  &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;  $1$  
    $\swarrow\quad \downarrow\quad \searrow$ &emsp;&emsp;&emsp;&emsp;&emsp;&ensp;&nbsp;$\swarrow\; \searrow$   
    $2\quad\;\; 3\qquad4$&emsp;&emsp;&emsp;&emsp;$null\ \ \ \ null$
- DAG with two node exist in the graph.  
  DAG-3: &nbsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;DAG-4: &nbsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;DAG-5:  
  $\;\quad1$  &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;  $\;\ \quad1$ &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;$\;\ \quad0$  
  $\swarrow\quad\searrow$  &emsp;&emsp;&emsp;&emsp;&emsp;&ensp;&ensp;&ensp;$\swarrow\quad\quad\;\; \downarrow\quad\; \searrow$&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;&nbsp; $\swarrow\quad\searrow$   
  $2\quad\quad 3$ &emsp;&emsp;&emsp;&emsp;&emsp;&emsp; $2\quad\quad\;\;\;\; 3\qquad\;\;0$ &emsp;&emsp;&emsp;&emsp;&emsp;&nbsp; $1\quad\quad\; 2$  
  $\downarrow\qquad \downarrow$ &emsp;&emsp;&emsp;&emsp;&emsp; $\swarrow\searrow$  &emsp; $\swarrow\;\;\searrow$ &nbsp;&nbsp;&nbsp;$\swarrow$&emsp;&emsp;&emsp;&emsp;&emsp;$\swarrow\quad\quad\swarrow$    
  $4\;\rightarrow\;5$ &emsp;&emsp;&emsp;&emsp;&ensp; $4\rightarrow5$ &ensp;$\;6\;\rightarrow\;7$&emsp;&emsp;&emsp;&emsp;&ensp;&emsp;&ensp;&nbsp;$3\qquad\;\;4$     
  $\searrow\quad\swarrow$&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;$\swarrow$&emsp;&emsp;&nbsp; $\swarrow\ \ \;\searrow$   
  $\;\quad0$&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;$5\qquad\ \ 6\qquad\ \ 7$
  &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&ensp;&nbsp;$\downarrow$  
  &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&ensp;&nbsp;$8$   
  &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;$\swarrow\quad \downarrow\quad \searrow$  
  &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;$9\quad\;\; 10\quad\ 11$  
  &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;$\searrow$  
  &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;$12$  
  &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;$\searrow$
  &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;$13$  
 DAG-6