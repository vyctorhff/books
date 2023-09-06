package br.study.mixing.base64.service;

import br.study.mixing.base64.Base64Exception;
import br.study.mixing.base64.converts.ConvertStringAndNumber;
import br.study.mixing.base64.converts.impl.ConvertNumberAndBinary;
import br.study.mixing.base64.grouping.GrouppingBytes;
import br.study.mixing.base64.table.TableInfo;
import br.study.mixing.base64.table.TableList;
import br.study.mixing.base64.table.base64.Base64Table;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class Base64EncoderService {

    private final GrouppingBytes groupingToSixBits;
    private final ConvertStringAndNumber convertStringAndNumber;
    private final ConvertNumberAndBinary convertNumberAndBinary;
    
    public String process(String input) throws Base64Exception {
        // 2 - Convert each chracter to ASCII(unicode) decimal
        List<Integer> numberAsAscii = this.getAscii(input);

        // 3 - Convert each decimal to binary
        List<String> convertBinary = this.getBinary(numberAsAscii);

        // 4 - Convert the 8 bits in 6 bits representation
        List<String> groupingSixBits = this.getGroupingSixBits(convertBinary);

        // 5 - Convert each 6 bits sequence to a number
        List<Integer> integerFromSixBits = this.getIntegerFromSixBits(groupingSixBits);

        // 6 - Convert each number to a character based on base 64 table
        List<String> characertSixBits = this.getCharacterFromNumber(integerFromSixBits);

        // 7 - Concat the role sequence to a string
        return String.join(StringUtils.EMPTY, characertSixBits);
    }

    private List<String> getCharacterFromNumber(List<Integer> integerFromSixBits) {
        List<String> result = new ArrayList<>();

        TableList table = new Base64Table();
        integerFromSixBits.forEach(value -> {
            Optional<TableInfo> optTable = table.findByCode(value);

            result.add(optTable.get().getCharacterAsString());
        });

        return result;
    }

    private List<Integer> getIntegerFromSixBits(List<String> groupingSixBits) {
        List<Integer> result = new ArrayList<>();

        groupingSixBits.forEach(value -> {
            var split = value.split(StringUtils.SPACE);

            for (String fragment : split) {
                result.add(this.convertNumberAndBinary.convertToNumber(fragment));
            }
        });

        return result;
    }

    private List<String> getGroupingSixBits(List<String> convertBinary) {
        List<String> result = new ArrayList<>();

        String completeGroup = String.join(StringUtils.SPACE, convertBinary);
        for (String str : this.groupingToSixBits.process(completeGroup)) {
            result.add(str);
        }

        return result;
    }

    private List<String> getBinary(List<Integer> numberAsAscii) {
        List<String> result = new ArrayList<>();

        numberAsAscii.forEach(value -> {
            result.add(
                this.convertNumberAndBinary.convertToBinary(value)
            );
        });

        return result;
    }

    private List<Integer> getAscii(String input) throws Base64Exception {
        List<Integer> result = new ArrayList<>();

        for (char character : input.toCharArray()) {
            result.add(
                this.convertStringAndNumber.convert(Character.toString(character))
            );
        }

        return result;
    }
}
