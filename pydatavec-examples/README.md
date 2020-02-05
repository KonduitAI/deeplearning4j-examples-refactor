-Whatizthis

pip install pydatavec


errors when running basic.py

```
pdl4j: required uberjar not found, building with docker...
Docker available. Starting build...
Cannot connect to the Docker daemon at unix:///var/run/docker.sock. Is the docker daemon running?
Traceback (most recent call last):
  File "basic.py", line 19, in <module>
    from pydatavec import Schema, TransformProcess
  File "/Users/susaneraly/anaconda3/lib/python3.6/site-packages/pydatavec/__init__.py", line 20, in <module>
    from .transform_process import *
  File "/Users/susaneraly/anaconda3/lib/python3.6/site-packages/pydatavec/transform_process.py", line 23, in <module>
    from .java_classes import JString
  File "/Users/susaneraly/anaconda3/lib/python3.6/site-packages/pydatavec/java_classes.py", line 23, in <module>
    pydl4j.validate_datavec_jars()
  File "/Users/susaneraly/anaconda3/lib/python3.6/site-packages/pydl4j/pydl4j.py", line 321, in validate_datavec_jars
    validate_jars()
  File "/Users/susaneraly/anaconda3/lib/python3.6/site-packages/pydl4j/pydl4j.py", line 308, in validate_jars
    maven_build()
  File "/Users/susaneraly/anaconda3/lib/python3.6/site-packages/pydl4j/pydl4j.py", line 275, in maven_build
    _maven_build(use_docker=True)
  File "/Users/susaneraly/anaconda3/lib/python3.6/site-packages/pydl4j/pydl4j.py", line 256, in _maven_build
    docker_build()
  File "/Users/susaneraly/anaconda3/lib/python3.6/site-packages/pydl4j/pydl4j.py", line 224, in docker_build
    call(["docker", "build", _MY_DIR, "-t", "pydl4j"])
  File "/Users/susaneraly/anaconda3/lib/python3.6/site-packages/pydl4j/pydl4j.py", line 32, in call
    raise Exception('Subprocess error for command: ' + str(arglist))
Exception: Subprocess error for command: ['docker', 'build', '/Users/susaneraly/.deeplearning4j/pydl4j', '-t', 'pydl4j']
```
