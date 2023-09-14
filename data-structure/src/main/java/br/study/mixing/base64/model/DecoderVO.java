package br.study.mixing.base64.model;

import br.study.mixing.base64.DecodeInput;
import br.study.mixing.base64.table.TableInfo;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Data
public class DecoderVO {

    private final String input;

    private List<Integer> numberAsAscii;
    private List<Integer> integerFromSixBits;

    private List<String> characertSixBits;
    private List<String> convertBinary;
    private List<String> groupingSixBits;

    public DecoderVO(String input) {
        this.input = input;

        this.numberAsAscii = new ArrayList<>();
        this.integerFromSixBits = new ArrayList<>();

        this.convertBinary = new ArrayList<>();
        this.groupingSixBits = new ArrayList<>();
        this.characertSixBits = new ArrayList<>();
    }

    public void addLetterFromBinarySix(Function<Integer, Optional<TableInfo>> function) {
        getIntegerFromSixBits().forEach(value -> {
            Optional<TableInfo> optTable = function.apply(value);

            if (optTable.isEmpty()) {
                throw new IllegalArgumentException("letter not valid: ");
            }

            this.characertSixBits.add(optTable.get().getCharacterAsString());
        });
    }

    public void addNumberFromBinarySix(Function<String, Integer> function) {
        this.getGroupingSixBits().forEach(value -> {
            var split = value.split(StringUtils.SPACE);

            for (String fragment: split) {
                this.integerFromSixBits.add(function.apply(fragment));
            }
        });
    }

    public void addBinarySixFromBinaryEigth(Function<String, List<String>> function) {
        String completeGroup = String.join(StringUtils.SPACE, this.getConvertBinary());

        function.apply(completeGroup).forEach(value -> {
            this.groupingSixBits.add(value);
        });
    }

    public void addBinaryFromNumber(Function<Integer, String> function) {
        this.getNumberAsAscii().forEach(value -> {
            this.convertBinary.add(function.apply(value));
        });
    }

    public void addNumberFromAscII(Function<Character, Integer> function) {
        for (char character: this.getInput().toCharArray()) {

            // ignore convert for padding symbol
            if (DecodeInput.PADDING_SYMBOL == character) {
                continue;
            }

            this.numberAsAscii.add(function.apply(character));
        }
    }

    public String getResult() {
        return String.join(StringUtils.EMPTY, characertSixBits);
    }
}
