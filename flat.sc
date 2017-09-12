import ammonite.ops._

@main
def main(e: String = "svg", n: String = "", f: String = "") {
	val filters = f.split(",").toSeq
	val args = (filters ++ Seq(n, e)).filter(_.nonEmpty) mkString "-"
	val destinationFolder = s"dist-$args"
	val destination = pwd/destinationFolder

	println(s"Removing old destination folder $destinationFolder")
	rm! destination

	println(s"Creating destination folder $destinationFolder")
	mkdir! destination

	println("Copying files...")

	// The path of the folder where the icons live
	val path: Path = pwd / "material-design-icons"

	// All files in the path that match the given filters
	var files = ls.rec! path |? (path => _contains(path, filters) && path.name.contains(n) && path.ext == e)

	// Find duplicate files
	val duplicateFiles = files.map(_.last).diff(files.map(_.last).distinct).distinct
	if (!duplicateFiles.isEmpty) {
		println("The following copies were found:\n" + duplicateFiles)

		println("Removing duplicate files from list")
		files = files.groupBy(_.last).values.map(_.head).toList
	}

	files.foreach((file: Path) => cp.into(file, destination))

	if (files.length > 0) println(s"SUCCESS: copied ${files.length} files")
	else println("FAILURE: No files found that match the given criteria.")
}

def _contains(p: Path, ls: Seq[String]): Boolean = {
	// Empty filter should match all files
	ls.forall(s => if (s.isEmpty) true else p.segments.contains(s))
}
