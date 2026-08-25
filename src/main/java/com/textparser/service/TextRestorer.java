package com.textparser.service;

import com.textparser.entity.Text;

public class TextRestorer {
        public String restore(Text text){
            return text.getOriginalText();
        }
}
