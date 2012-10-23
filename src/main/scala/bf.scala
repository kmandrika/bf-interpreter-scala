//  Copyright (C) 2012  Konstantin Mandrika
//
//  This program is free software: you can redistribute it and/or modify
//  it under the terms of the GNU General Public License as published by
//  the Free Software Foundation, either version 3 of the License, or
//  (at your option) any later version.
//
//  This program is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//  GNU General Public License for more details.
//
//  You should have received a copy of the GNU General Public License
//  along with this program.  If not, see <http://www.gnu.org/licenses/>.

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
