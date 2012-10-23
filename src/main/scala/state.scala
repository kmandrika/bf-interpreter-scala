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

import scala.collection.mutable.{ArrayBuffer}

class State {
    private var cells: ArrayBuffer[Int] = new ArrayBuffer[Int];
    private var pc: Int = 0;

    cells += 0;

    //! Operates on the value of the current cell.
    def decrement = { cells(pc) -= 1; }
    def increment = { cells(pc) += 1; }

    //! Operates on the PC.
    def retreat(value: Int) = { pc -= value; }
    def advance(value: Int) = {
        pc += value;

        //! Resize the cells.
        if (pc >= cells.size)
            cells += 0;
    }

    //! Operates on the current value of the cell.
    def value = { cells(pc); }
    def out = { print(cells(pc).toChar); }
}
