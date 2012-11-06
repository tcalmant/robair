.. Java code for RobAIR/Wifibot

RobAIR/Wifibot Java
###################

Configuration
*************

Configuration of components is currently hard-coded.
Further development will allow to use a Java properties file.

Requirements
************

Eclipse plugins
===============

This directory contains Eclipse projects, some of them need a specific Eclipse
plug-in,
`iPOJO Nature <http://gitorious.ow2.org/ow2-chameleon/eclipse-ipojo-builder>`_.

To install it, you will need to build it with Maven 3:

.. code-block:: bash

   # Grab the code
   $ git clone http://git.gitorious.ow2.org/ow2-chameleon/eclipse-ipojo-builder.git
   $ cd eclipse-ipojo-builder
   # Change of development branch
   $ git -b new-manipulator origin/new-manipulator
   # Build it
   $ cd trunk
   $ mvn clean install

Then you will have to add the /trunk/update-site/target/site folder as an
update site in your Eclipse installation.

Jitsi
=====

The Java projects in this folder are OSGi bundles, and contains iPOJO
components.

To run this code, you will need iPOJO core and iPOJO annotations to be
installed in your OSGi framework.
They can be downloaded from `here <http://felix.apache.org/site/download.html>`_.

The code has been tested with the
`Apache Felix <http://felix.apache.org/site/index.html>`_ framework, embedded in
an instance of `Jitsi <https://jitsi.org/>`_ (nightly built), an open-source
Java/OSGi instant messaging project.


Wiimote
=======

The *fr.imag.erods.robair.nunchuk* project contains a WireAdmin consumer which
needs a *Wiimote* producer to work.
This producer can be downloaded from the JOnAS sandboxes and built with Maven.

.. code-block:: bash

   $ svn checkout svn://svn.forge.objectweb.org/svnroot/jonas/demo/jonas-wiimote


On Linux, you will also need to install Bluecove for the Bluetooth
communications:

.. code-block:: bash
   # For Fedora
   $ yum install bluecove
