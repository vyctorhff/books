package br.study.mixing.base64.service;

import br.study.mixing.base64.Base64Exception;
import br.study.mixing.base64.converts.ConvertStringAndNumber;
import br.study.mixing.base64.converts.impl.ConvertNumberAndBinary;
import br.study.mixing.base64.grouping.GrouppingBytes;
import br.study.mixing.base64.model.DecoderVO;
import br.study.mixing.base64.table.TableList;
import br.study.mixing.base64.table.base64.Base64Table;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Base64EncoderService {

    private final GrouppingBytes groupingToSixBits;
    private final ConvertStringAndNumber convertStringAndNumber;
    private final ConvertNumberAndBinary convertNumberAndBinary;
    
    public String process(String input) throws Base64Exception {
        DecoderVO vo = new DecoderVO(input);

        // 2 - Convert each character to ASCII(unicode) decimal
        this.processAscIIToNumber(vo);

        // 3 - Convert each decimal to binary
        this.processBinaryFromNumber(vo);

        // 4 - Convert the 8 bits in 6 bits representation
        this.processBinarySixFromBinaryEigth(vo);

        // 5 - Convert each 6 bits sequence to a number
        this.processNumberFromBinarySix(vo);

        // 6 - Convert each number to a character based on base 64 table
        this.processLetterFromBinarySix(vo);

        // 7 - Concat the role sequence to a string
        return vo.getResult();
    }

    private void processLetterFromBinarySix(DecoderVO vo) {
        TableList table = new Base64Table();
        vo.addLetterFromBinarySix(value -> table.findByCode(value));
    }

    private void processNumberFromBinarySix(DecoderVO vo) {
        vo.addNumberFromBinarySix(value -> this.convertNumberAndBinary.convertToNumber(value));
    }

    private void processBinarySixFromBinaryEigth(DecoderVO vo) {
        vo.addBinarySixFromBinaryEigth(completeGroup -> this.groupingToSixBits.process(completeGroup));
    }

    private void processBinaryFromNumber(DecoderVO vo) {
        vo.addBinaryFromNumber(number -> this.convertNumberAndBinary.convertToBinary(number));
    }

    private void processAscIIToNumber(DecoderVO vo) throws Base64Exception {
        vo.addNumberFromAscII(character -> {
            try {
                return this.convertStringAndNumber.convert(Character.toString(character));
            } catch (Base64Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
