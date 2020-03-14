#! /bin/sh
#
# Package everything for release :).
#
##

# Check args
if (( $# < 2 )) ; then
	echo "Not enough args!"
	exit 1
fi

KUAL_VERSION="${1}"
KUAL_DATE="${2}"

echo "Packaging KUAL ${KUAL_VERSION} (${KUAL_DATE}) . . ."

# Handle being called from a different directory (ie. by ant)...
WD="${0%/*}"
cd "${WD}"

# Clean target directory...
rm -f ../../../../../../../target/*.tar.xz

# Build the Booklet update package
./build-updates.sh "${KUAL_VERSION}"

# Make Windows users happy...
unix2dos -k ../target/*.txt ../../../../../../../*.txt

# And package it (flatten the directory structure)
tar --exclude='MR_THREAD.txt' --transform 's,^.*/,,S' --show-transformed-names -cvJf ../../../../../../../target/KUAL-${KUAL_VERSION}-${KUAL_DATE}.tar.xz ../target/* ../../../../../../../*.azw2 ../../../../../../../*.txt

# Git handles this properly, but it shouts at us a bit...
dos2unix -k ../target/*.txt ../../../../../../../*.txt

# Cleanup behind build-updates
rm -f ../target/*.bin

# Go back
cd - &>/dev/null
