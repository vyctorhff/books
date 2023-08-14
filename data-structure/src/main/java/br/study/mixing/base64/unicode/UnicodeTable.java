package br.study.mixing.base64.unicode;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Data
public class UnicodeTable {

    private List<UnicodeInfo> list;

    public void init() {
        this.list = new ArrayList<>();
        this.list.addAll(this.getBasicLetters());
    }

    private List<UnicodeInfo> getBasicLetters() {
        return List.of(
            new UnicodeInfo(32, ' '),
            new UnicodeInfo(33, '!'),
            new UnicodeInfo(34, '"'),
            new UnicodeInfo(35, '#'),
            new UnicodeInfo(36, '$'),
            new UnicodeInfo(37, '%'),
            new UnicodeInfo(38, '&'),
            new UnicodeInfo(39, '\''),
            new UnicodeInfo(40, '('),
            new UnicodeInfo(41, ')'),
            new UnicodeInfo(42, '*'),
            new UnicodeInfo(43, '+'),
            new UnicodeInfo(44, ','),
            new UnicodeInfo(45, '-'),
            new UnicodeInfo(46, '.'),
            new UnicodeInfo(47, '/'),
            new UnicodeInfo(48, '0'),
            new UnicodeInfo(49, '1'),
            new UnicodeInfo(50, '2'),
            new UnicodeInfo(51, '3'),
            new UnicodeInfo(52, '4'),
            new UnicodeInfo(53, '5'),
            new UnicodeInfo(54, '6'),
            new UnicodeInfo(55, '7'),
            new UnicodeInfo(56, '8'),
            new UnicodeInfo(57, '9'),
            new UnicodeInfo(58, ':'),
            new UnicodeInfo(59, ';'),
            new UnicodeInfo(60, '<'),
            new UnicodeInfo(61, '='),
            new UnicodeInfo(62, '>'),
            new UnicodeInfo(63, '?'),
            new UnicodeInfo(64, '@'),
            new UnicodeInfo(65, 'A'),
            new UnicodeInfo(66, 'B'),
            new UnicodeInfo(67, 'C'),
            new UnicodeInfo(68, 'D'),
            new UnicodeInfo(69, 'E'),
            new UnicodeInfo(70, 'F'),
            new UnicodeInfo(71, 'G'),
            new UnicodeInfo(72, 'H'),
            new UnicodeInfo(73, 'I'),
            new UnicodeInfo(74, 'J'),
            new UnicodeInfo(75, 'K'),
            new UnicodeInfo(76, 'L'),
            new UnicodeInfo(77, 'M'),
            new UnicodeInfo(78, 'N'),
            new UnicodeInfo(79, 'O'),
            new UnicodeInfo(80, 'P'),
            new UnicodeInfo(81, 'Q'),
            new UnicodeInfo(82, 'R'),
            new UnicodeInfo(83, 'S'),
            new UnicodeInfo(84, 'T'),
            new UnicodeInfo(85, 'U'),
            new UnicodeInfo(86, 'V'),
            new UnicodeInfo(87, 'W'),
            new UnicodeInfo(88, 'X'),
            new UnicodeInfo(89, 'Y'),
            new UnicodeInfo(90, 'Z'),
            new UnicodeInfo(91, '['),
            new UnicodeInfo(92, '\\'),
            new UnicodeInfo(93, ']'),
            new UnicodeInfo(94, '^'),
            new UnicodeInfo(95, '_'),
            new UnicodeInfo(96, '`'),
            new UnicodeInfo(97, 'a'),
            new UnicodeInfo(98, 'b'),
            new UnicodeInfo(99, 'c'),
            new UnicodeInfo(100,	'd'),
            new UnicodeInfo(101,	'e'),
            new UnicodeInfo(102,	'f'),
            new UnicodeInfo(103,	'g'),
            new UnicodeInfo(104,	'h'),
            new UnicodeInfo(105,	'i'),
            new UnicodeInfo(106,	'j'),
            new UnicodeInfo(107,	'k'),
            new UnicodeInfo(108,	'l'),
            new UnicodeInfo(109,	'm'),
            new UnicodeInfo(110,	'n'),
            new UnicodeInfo(111,	'o'),
            new UnicodeInfo(112,	'p'),
            new UnicodeInfo(113,	'q'),
            new UnicodeInfo(114,	'r'),
            new UnicodeInfo(115,	's'),
            new UnicodeInfo(116,	't'),
            new UnicodeInfo(117,	'u'),
            new UnicodeInfo(118,	'v'),
            new UnicodeInfo(119,	'w'),
            new UnicodeInfo(120,	'x'),
            new UnicodeInfo(121,	'y'),
            new UnicodeInfo(122,	'z'),
            new UnicodeInfo(123,	'{'),
            new UnicodeInfo(124,	'|'),
            new UnicodeInfo(125,	'}'),
            new UnicodeInfo(126,	'~')
        );
    }

    public Optional<UnicodeInfo> findByCharacter(String input) {
        return this.list.stream()
            .filter(unicodeInfo -> input.equals(unicodeInfo.getCharacterAsString()))
            .findFirst();
    }

    public Optional<UnicodeInfo> findByCode(int code) {
        return this.list.stream()
            .filter(unicodeInfo -> code == unicodeInfo.getCode())
            .findFirst();
    }
}
