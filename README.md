# JavaWithPython
 This is a simple template for writing Python in Java.
# 在Java裡面寫Python

<aside>
💡 Repo：https://github.com/rei0313/JavaWithPython

</aside>

最近因為跟人合作需要使用其他人寫好的 `python` 檔案，所以研究了一下如何在 `Java` 的環境中運行 `python` 檔案的方法。附上簡易的 `template` ，整包拉下來就可以用了！

# Template說明

附上的Repo是 `Spring Boot` + `REST API` + `postgreSQL` 的配置，可以依照個人需求修改。

# 添加Dependency

到 `pom.xml` 加上 `jython` 這個套件。我這裡用 `2.7.1` 版本。

```xml
<dependency>
	<groupId>org.python</groupId>
	<artifactId>jython-standalone</artifactId>
	<version>2.7.1</version>
</dependency>
```

# 幫.py們找個位置

寫好 `.py` 的檔案，並放到專案底下。以下是我的結構，可以當作參考就好：

```
project
└───java
│   └───com.rei.javawithpython
│       │   config
│       │   controller
│       │   service
│       │   ...
│   
└───python
    │   hello.py
    │   ...(jython會幫你把.py編譯成java class!!)
```

# 在Java裡使用Python

以下程式碼參考自[Stack over flow](https://stackoverflow.com/questions/36286653/how-to-pass-arguments-to-python-script-in-java-using-jython)，如果需要更詳細的說明，可以到[jython官網](https://www.jython.org/)查看官方文件。

```java
try (PythonInterpreter interpreter = new PythonInterpreter()) {
            String scriptName = "HelloServicePython";
            interpreter.exec("import sys\n" + "import os \n" + "sys.path.append('" + "src/main/python/')\n" + "from " + scriptName + " import * ");
            String funcName = "myFunction";
            PyObject someFunc = interpreter.get(funcName);
            if (someFunc == null) {
                throw new Exception("Could not find Python function: " + funcName);
            }
            try {
                someFunc.__call__(new PyString(arg1), new PyString(arg2), new PyString(arg3));
            } catch (PyException e) {
                e.printStackTrace();
            }
        }
```
