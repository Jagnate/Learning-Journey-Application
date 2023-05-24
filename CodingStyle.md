# Coding Style
## Coding
### Tab
4 spaces

## Java Doc
### Header
```
/**
 *  Title      : xxx.java
 *  Description: xxx(The function of this class)
 * 
 *  In this version, xxx(changes and new functions)
 *  @author  Jin Si
 *  @version 1.0
 *  
 *  In this version, xxx
 *  @author XXX
 *  @author XXX
 *  @version 1.1
 */
 package xxx
 
 import xxx
 
 public class xxx{
     ....
 }
```
### Method
```
/** 
  * This method is used to ...(function)
  * @param aaa
  * @param bbb
  * @throws Exception
  * @return ccc
  */  
public int name(int aaa, String bbb){
  ...
  return ccc;
}
```
### Other comments
```
1. Attributes
/** 
 * This is the keyboard button, each button is a key.
 */
protected static JButton[] keyBoard = new JButton[28];

2. Inside a function
public int name(int aaa, String bbb){
  if(){ //This if statement is used to
      ...
  }
}
```
