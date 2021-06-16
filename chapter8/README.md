The java.io API defines two sets of classes for reading and writing streams: those with
Stream in their name and those with Reader/Writer in their name.\
The difference between stream and readers/writers:
1- the stream classes are used for inputting and outputting all types of binary or byte data.
2- the reader and writer classes are used for inputting and outputting only character and
String data.

The java.io library defines four abstract classes that are the parents of all stream classes
defined within the API: InputStream, OutputStream, Reader, and Writer.

The java.io stream class:\
- InputStream
- OutputStream
- Reader
- Writer
- FileInputStream, FileOutputStream, FileReader, FileWriter (Low)
- BufferedInputStream, BufferedOutputStream, BuffredReader, BufferedWriter (High)
- ObjectInputStream, ObjectOutputStream (High)
- InputStreamReader, OutputStreamWriter
- PrintStream, PrintWriter

![io types](etc/io_types.png)

Commons ops on streams:
- close
- flush
- mark
- skip

Desirialization:\
Important: constructor and any default
initializations are ignored during the deserialization process.

PrintWriter and PrintStream:\

