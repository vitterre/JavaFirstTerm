BASEDIR=$(dirname "$0")
CLASSDIR="$BASEDIR/out/production/JavaFirstTerm"
if [ -d "$CLASSDIR" ]; then
  javac $1 -d $CLASSDIR
else
  mkdir "$BASEDIR/out"
  mkdir "$BASEDIR/out/production"
  mkdir "$BASEDIR/out/production/JavaFirstTerm"
  javac $1 -d $CLASSDIR
fi

FULLRUNNAME=$(basename "$1")
RUNNAME="${FULLRUNNAME%.*}"
java -Dfile.encoding=UTF-8 -classpath $CLASSDIR $RUNNAME
