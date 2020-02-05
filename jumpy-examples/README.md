Whatizthis

- Install jumpy
pip install jumpy

Errors out when imported
>>> import jumpy as jp
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
  File "/Users/susaneraly/anaconda3/lib/python3.6/site-packages/jumpy/__init__.py", line 18, in <module>
    from .ndarray import *
  File "/Users/susaneraly/anaconda3/lib/python3.6/site-packages/jumpy/ndarray.py", line 18, in <module>
    from .java_classes import *
  File "/Users/susaneraly/anaconda3/lib/python3.6/site-packages/jumpy/java_classes.py", line 21, in <module>
    import pydl4j
ModuleNotFoundError: No module named 'pydl4j'


