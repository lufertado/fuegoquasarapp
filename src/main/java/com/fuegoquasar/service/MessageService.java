package com.fuegoquasar.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MessageService {

    public String getMessage(List<List<String>> messages) {
        List<String> messageParts = new ArrayList<>();
        for (int i = 0; i < messages.get(0).size(); i++) {
            Set<String> parts = new HashSet<>();
            for (List<String> satelliteMsgParts : messages) {
                String part = satelliteMsgParts.get(i);
                if (!part.trim().isEmpty()) {
                    parts.add(part);
                }
            }
            messageParts.addAll(parts);
        }
        StringBuilder sb = new StringBuilder();
        for (String msg : messageParts) {
            sb.append(msg);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

//    public String getMessage(List<List<String>> messages) {
//        List<String> messageParts = new ArrayList<>();
//        for (List<String> satelliteMsgParts : messages) {
//            List<String> satelliteMessages = satelliteMsgParts.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
//            if (messageParts.isEmpty()) {
//                messageParts.addAll(satelliteMessages);
//            } else {
//                int lastKnownPartPos = -1;
//                for (String messagePart : satelliteMessages) {
//                    if (messageParts.contains(messagePart)) {
//                        lastKnownPartPos = messageParts.indexOf(messagePart);
//                    } else {
//                        List<String> shiftedMessageParts = new ArrayList<>();
//                        if(lastKnownPartPos != -1) {
//                            shiftedMessageParts.addAll(messageParts.subList(0, lastKnownPartPos + 1));
//                        }
//                        shiftedMessageParts.add(messagePart);
//                        shiftedMessageParts.addAll(messageParts.subList(lastKnownPartPos + 1, messageParts.size()));
//                        messageParts = shiftedMessageParts;
//                    }
//                }
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//        for (String msg : messageParts) {
//            sb.append(msg);
//            sb.append(" ");
//        }
//        return sb.toString().trim();
//    }
}
