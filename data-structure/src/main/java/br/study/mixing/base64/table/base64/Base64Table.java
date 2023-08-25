package br.study.mixing.base64.table.base64;

import br.study.mixing.base64.table.TableInfo;
import br.study.mixing.base64.table.TableList;

import java.util.List;

public class Base64Table extends TableList {

    public List<TableInfo> getBasicLetters() {
        return List.of(
            new TableInfo(0, 'A'),
            new TableInfo(1, 'B'),
            new TableInfo(2, 'C'),
            new TableInfo(3, 'D'),
            new TableInfo(4, 'E'),
            new TableInfo(5, 'F'),
            new TableInfo(6, 'G'),
            new TableInfo(7, 'H'),
            new TableInfo(8, 'I'),
            new TableInfo(9, 'J'),
            new TableInfo(10, 'K'),
            new TableInfo(11, 'L'),
            new TableInfo(12, 'M'),
            new TableInfo(13, 'N'),
            new TableInfo(14, 'O'),
            new TableInfo(15, 'P'),
            new TableInfo(16, 'Q'),
            new TableInfo(17, 'R'),
            new TableInfo(18, 'S'),
            new TableInfo(19, 'T'),
            new TableInfo(20, 'U'),
            new TableInfo(21, 'V'),
            new TableInfo(22, 'W'),
            new TableInfo(23, 'X'),
            new TableInfo(24, 'Y'),
            new TableInfo(25, 'Z'),
            new TableInfo(26, 'a'),
            new TableInfo(27, 'b'),
            new TableInfo(28, 'c'),
            new TableInfo(29, 'd'),
            new TableInfo(30, 'e'),
            new TableInfo(31, 'f'),
            new TableInfo(32, 'g'),
            new TableInfo(33, 'h'),
            new TableInfo(34, 'i'),
            new TableInfo(35, 'j'),
            new TableInfo(36, 'k'),
            new TableInfo(37, 'l'),
            new TableInfo(38, 'm'),
            new TableInfo(39, 'n'),
            new TableInfo(40, 'o'),
            new TableInfo(41, 'p'),
            new TableInfo(42, 'q'),
            new TableInfo(43, 'r'),
            new TableInfo(44, 's'),
            new TableInfo(45, 't'),
            new TableInfo(46, 'u'),
            new TableInfo(47, 'v'),
            new TableInfo(48, 'w'),
            new TableInfo(49, 'x'),
            new TableInfo(50, 'y'),
            new TableInfo(51, 'z'),
            new TableInfo(52, '0'),
            new TableInfo(53, '1'),
            new TableInfo(54, '2'),
            new TableInfo(55, '3'),
            new TableInfo(56, '4'),
            new TableInfo(57, '5'),
            new TableInfo(58, '6'),
            new TableInfo(59, '7'),
            new TableInfo(60, '8'),
            new TableInfo(61, '9'),
            new TableInfo(62, '+'),
            new TableInfo(63, '/')
        );
    }
}
