.. Python code for Wifibot

Wifibot Python
##############

Configuration
*************

To modify the configuration of this sample, edit the *main.py* file:

* ``BUNDLES`` (line 20): contains the list of modules to install in the Pelix
  framework. 

* ``props`` (line 35): sets up the properties of the framework, i.e. the
  configuration of components.


Requirements
************

.. important:: This code won't work *as is* on Python 3.x.

.. note:: You need to install python *setup tools* (``easy_install``)
   to execute the following commands.

* Pelix/iPOPO: an OSGi like framework in Python.
  It needs a Python >= 2.6 to work.
  More information on Pelix `here <http://ipopo.coderxpress.net/>`_.

  .. code-block:: bash
  
     $ wget https://github.com/tcalmant/robair/archive/master.zip
     $ unzip master.zip
     $ cd ipopo-master
     $ sudo python setup.py install

  .. note:: If you are using Python 2.6, you also need to install the
     ``importlib`` backport package:
     
     .. code-block:: bash
  
        $ sudo easy_install -U importlib

* Python ``xmpp`` package: for XMPP communications

  .. code-block:: bash
  
     $ sudo easy_install -U xmpppy
