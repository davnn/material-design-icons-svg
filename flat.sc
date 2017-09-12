import ammonite.ops._

@main
def main(i: String = "svg", k: String = "design", s: String = "svg") {
	println("Removing old destination folder (dist)")
	rm! pwd/'dist

	println("Creating destination folder (dist)")
	mkdir! pwd/'dist

	println("Copying files to destination folder")

	// The path of the folder where the svg icons live
	val path: Path = pwd / "material-design-icons"

	// All SVG files in the path that match the given filters
	var svgFiles = ls.rec! path |? (_.ext == "svg") |? (_.segments contains i) |? (_.segments contains k) |? (_.name contains s)

	// Find duplicate files
	val duplicateFiles = svgFiles.map(_.last).diff(svgFiles.map(_.last).distinct).distinct
	if (!duplicateFiles.isEmpty) {
		println("The following copies were found:\n" + duplicateFiles)
		
		println("Removing duplicate files from list")
		svgFiles = svgFiles.groupBy(_.last).values.map(_.head).toList
	}

	svgFiles.foreach((file: Path) => cp.into(file, pwd/'dist))

	println(s"SUCCESS: copied ${svgFiles.length} files")
}
