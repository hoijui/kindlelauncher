#! /bin/sh
#
# Simple wrapper around the strip awk script to make it easier to call from an ant task
#
##

# Handle being called from a different directory (ie. by ant)...
WD="${0%/*}"

# Check that we actually have a decent awk implementation.
# Do it before we mess with I/O redirection, so that we get the error diagnostic through ant
# We rely on GNU Awk 4 at the very least.
if [[ "$(env gawk -V 2>/dev/null | grep -e 'GNU Awk' | cut -c 9)" -lt "4" ]] ; then
	echo "*!!* Your GNU Awk version is too old! We need GNU Awk 4 ;) *!!*"
	exit 1
fi

echo "y" | env gawk ${WD}/strip.awk -v AWK=1 ${WD}/../parse-commented.awk > ${WD}/../parse.awk
