package com.rei.javawithpython.controller;

import lombok.extern.slf4j.Slf4j;
import org.python.core.PyException;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class TestController {

    @PostMapping
    public void getQuestion(@RequestParam String arg1, @RequestParam String arg2, @RequestParam String arg3) throws Exception {
        log.info("已進入controller");
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
    }

}
