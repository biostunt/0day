#!/bin/bash

echo "adding files";

git add .;
git commit -m "$1";
git push;
