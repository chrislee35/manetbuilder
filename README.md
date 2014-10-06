# ManetBuilder

## Purpose
ManetBuilder is designed to aid wireless network systems engineers and
telecommunications researchers in creating wireless topologies with
mobility.  You'll find many features in this program that help users to
quickly see the relationships between wireless nodes such as displaying 
signal ranges, communication links, distances, mobility paths, and 
application connections.  As of version 0.3, there is no support for
adding wired networks. ManetBuilder is written in Java.

## Download
Thank you for being interested in using ManetBuilder.  I hope you enjoy using it and that you can accomplish whatever task you are up against.

* <a href='http://www.chrisleephd.us/projects/manetbuilder/manetbuilder-0.5.jar'>manetbuilder-0.5.jar</a>
* <a href='http://www.chrisleephd.us/projects/manetbuilder/manetbuilder-0.4.jar'>manetbuilder-0.4.jar</a>

## Ready, Start, Create
So you're ready to dig into ManetBuilder.  Here are the different user manuals
developed to help you get a fast start and handle difficult problems.
- <a href='http://www.chrisleephd.us/projects/manetbuilder/usersguide.pdf'>Preliminary User's Guide</a>
	1.7 MB

## Development
There are three areas for add-ons and extensions: file generators, mobility
models, and applications. File generators are used to save and load files in the various formats. 
Mobility models are used to track information pertaining to a node's mobility,
such as waypoints, speeds, or variability.  Application models are used to
attach application-level information to a node or nodes.  Some applications 
only effect one node (such as a broadcast), while others would effect a pair 
of nodes, such as an HTTP session or CBR traffic.

## Screenshots
One of the quickest ways of finding out if a product is right for you is to take
a look at the interface.  A lot of time and thought was put into making this tool
easy and quick to use.  As such, there are a lot of keyboard short-cuts and mouse
tricks to speed the building process.

<img src='http://www.chrisleephd.us/projects/manetbuilder/manet1.png' />

This is the major marketing slide picture that shows all the major features of the program.
The green lines are mobility lines. The gray circles denote the radio ranges of the nodes. 
The red line denotes a unidirection communications link. And the black dots represent the
nodes' positions at the time in question (230 seconds).  There is a map loaded in the
background as an image.

<img src='http://www.chrisleephd.us/projects/manetbuilder/manet2.png' />

There are many options on how to change which details are displayed on the screen.  You can turn on and off all of the following:
- *All Ranges* - Shows the transmission ranges of all the individual nodes.
- *Links* - Shows a blue line for bidirectional links and red lines for unidirectional links.
- *Coordinates* - Displays the nodes' current coordinates next to the node on the map.
- *Lengths* - Annotes the links (if shown) with the distances between the nodes.
- *Grid* - Draws a cute little grid on the background.
- *Background* - Displays the background image if specified when the map was created.


<img src='http://www.chrisleephd.us/projects/manetbuilder/manet3.png' />

This is a zoomed in version.  This allows you to lay down nodes with more control and to be able to see more details.
For ultimate placement control, you can type in the x and y coordinates with the accuracy of a Java double.

<img src='http://www.chrisleephd.us/projects/manetbuilder/manet4.png' />

You can also type in a new value for the range of a nodes transmitter.

<img src='http://www.chrisleephd.us/projects/manetbuilder/manet5.png' />

You have four options when creating a new map: a background image, the map's height and width, and the simulation time.

<img src='http://www.chrisleephd.us/projects/manetbuilder/manet6.png' />

This shows the selection of the Georgia Tech image (Yahoo Map) for use in a new map.

<img src='http://www.chrisleephd.us/projects/manetbuilder/manet7.png' />

The next two images illustrate that you can lay down a node's path at time 120, and then go back to time 60, and add a bend to the path.

<img src='http://www.chrisleephd.us/projects/manetbuilder/manet8.png' />

## Contributing

1. Fork it
2. Create your feature branch (`git checkout -b my-new-feature`)
3. Commit your changes (`git commit -am 'Add some feature'`)
4. Push to the branch (`git push origin my-new-feature`)
5. Create new Pull Request

<a href='mailto:github@chrislee[dot]dhs[dot]org[stop here]xxx'><img src='http://chrisleephd.us/images/github-email.png?manetbuilder'></a>
