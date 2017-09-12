# All Material Design Icons in one folder

This is just a copy of Google's [Material Design Icons](https://github.com/google/material-design-icons), copied into one flat folder. Needed this to get all material icons into [IconJar](https://geticonjar.com/) nicely and didn't find anything online.

```sh
# Run the script with default values
amm flat.sc

# Specify an iconset (default all)
amm flat.sc -i action

# Specify the size (default all)
amm flat.sc -s 24px

# Specify which kind of files (default design)
amm flat.sc -k production
```

Script written with [Ammonite](http://ammonite.io/), the Scala shell.