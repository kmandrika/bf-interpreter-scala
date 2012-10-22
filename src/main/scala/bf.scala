object Bf {
    def main(args: Array[String]) {
        def usage = {
            println("Usage: [OPTION]... <source-file>");
            println("Options:");
            println("  -e, --evaluate-program    evaluate a one line program");
            println("  -h, --help                print this message");
        }

        val Eval = "(?:-e|--evaluate-program)=(.*)".r;
        val File = "([^-].*)".r;

        args map { _ match {
            case Eval(p) => return new Evaluate(p).result
            case File(f) => {
                try {
                    return new Evaluate(
                        scala.io.Source.fromFile(f).mkString
                    ).result;
                }
                catch {
                    case _ => println("Couldn't open file!");
                }
            }
            case "-h" | "--help" | _ => return usage;
        }}
    }
}
