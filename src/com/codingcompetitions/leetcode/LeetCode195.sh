# Examples can be tried out here: https://repl.it/languages/bash
# Read from the file file.txt and output the tenth line to stdout.
lineCount=`cat file.txt | wc -l`
if [ $lineCount -ge 10 ]
then
head -10 file.txt | tail -1
fi