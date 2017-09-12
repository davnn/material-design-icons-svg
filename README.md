# All Material Design Icons in one folder

This is just a copy of Google's [Material Design Icons](https://github.com/google/material-design-icons), copied into one flat folder. Needed this to get all material icons into [IconJar](https://geticonjar.com/) nicely and didn't find anything online.

Script written with [Ammonite](http://ammonite.io/), the Scala shell.

```sh
# Initialiase the git submodule (google/material-design-icons)
git submodule init

# Update the git submodule
git submodule update

# Run the script with default values
amm flat.sc

# Specify a file extension (default svg)
amm flat.sc -e png

# Specify a part of the filename (default "")
amm flat.sc -n 24px

# Specify parts of the path separated by commas (default "")
amm flat.sc -f design,action

# Example of all 24px .svg files in folders action && production
amm flat.sc -e svg -n 24px -f action,production
```
