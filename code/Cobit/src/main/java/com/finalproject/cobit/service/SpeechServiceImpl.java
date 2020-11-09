package com.finalproject.cobit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;

@Service
public class SpeechServiceImpl implements SpeechSerivce {

	@Override
	public List<String> analyzeText1(List<String> texts) {
		Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);
//		List<String> temp = new ArrayList<String>();
//		temp.add("앞으로 네 칸 가기");
		List<String> commands = null;
		for (String string : texts) {
			KomoranResult analyzeResultList = komoran.analyze(string);
			String common = analyzeResultList.getPlainText();
			System.out.println(common);
			List<String> targetPosCollection = new ArrayList<String>();
			targetPosCollection.add("NNG");
			targetPosCollection.add("NP");
			targetPosCollection.add("NNP");
			targetPosCollection.add("SN");
			targetPosCollection.add("MM");
			List<String> list = analyzeResultList.getMorphesByTags(targetPosCollection);
			System.out.println(string+" "+list.toString());
			if(commands == null) {
				
				commands = makeCommand(list);
			}else {
				commands.addAll(makeCommand(list));
			}
		}
		return commands;
	}

	private List<String> makeCommand(List<String> list) {
		List<String> result = new ArrayList<String>();
		int N = list.size();
		for(int i = 0; i < N; i++) {
			String command = list.get(i);
			if(command.contains("앞")) {
				if(i != N-1) {
					char nextCommand = list.get(i+1).charAt(0);
					String next = list.get(i+1);
					if(nextCommand>='1' && nextCommand<='9') {
						int iter = nextCommand-'0';
						for(int j = 0; j < iter; j++) {
							result.add("forward");
						}
						i++;
					}else if(nextCommand == '한') {
						result.add("forward");
						i++;
					}else if(nextCommand == '두') {
						for(int j = 0 ; j < 2; j++) {
							result.add("forward");
						}
						i++;
					}else if(nextCommand == '세') {
						for(int j = 0 ; j < 3; j++) {
							result.add("forward");
						}
						i++;
					}else if(nextCommand == '네' || nextCommand == '내') {
						for(int j = 0 ; j < 4; j++) {
							result.add("forward");
						}
						i++;
					}else if(next.contains("다섯")) {
						for(int j = 0 ; j < 5; j++) {
							result.add("forward");
						}
						i++;
					}else if(next.contains("여섯")) {
						for(int j = 0 ; j < 6; j++) {
							result.add("forward");
						}
						i++;
					}else if(next.contains("일곱")) {
						for(int j = 0 ; j < 7; j++) {
							result.add("forward");
						}
						i++;
					}else if(next.contains("여덜") || next.contains("여덟")) {
						for(int j = 0 ; j < 8; j++) {
							result.add("forward");
						}
						i++;
					}else if(next.contains("아홉")) {
						for(int j = 0 ; j < 9; j++) {
							result.add("forward");
						}
						i++;
					}
				}else {
					result.add("forward");
				}
			}else if(command.contains("뒤")) {
				if(i != N-1) {
					char nextCommand = list.get(i+1).charAt(0);
					String next = list.get(i+1);
					if(nextCommand>='1' && nextCommand<='9') {
						int iter = nextCommand-'0';
						for(int j = 0; j < iter; j++) {
							result.add("back");
						}
						i++;
					}else if(nextCommand == '한') {
						result.add("back");
						i++;
					}else if(nextCommand == '두') {
						for(int j = 0 ; j < 2; j++) {
							result.add("back");
						}
						i++;
					}else if(nextCommand == '세') {
						for(int j = 0 ; j < 3; j++) {
							result.add("back");
						}
						i++;
					}else if(nextCommand == '네' || nextCommand == '내') {
						for(int j = 0 ; j < 4; j++) {
							result.add("back");
						}
						i++;
					}else if(next.contains("다섯")) {
						for(int j = 0 ; j < 5; j++) {
							result.add("back");
						}
						i++;
					}else if(next.contains("여섯")) {
						for(int j = 0 ; j < 6; j++) {
							result.add("back");
						}
						i++;
					}else if(next.contains("일곱")) {
						for(int j = 0 ; j < 7; j++) {
							result.add("back");
						}
						i++;
					}else if(next.contains("여덜") || next.contains("여덟")) {
						for(int j = 0 ; j < 8; j++) {
							result.add("back");
						}
						i++;
					}else if(next.contains("아홉")) {
						for(int j = 0 ; j < 9; j++) {
							result.add("back");
						}
						i++;
					}
				}else {
					result.add("back");
				}
			}else if(command.contains("왼쪽")) {
				result.add("turnLeft");
			}else if(command.contains("오른쪽")) {
				result.add("turnRight");
			}else if(command.contains("한")) {
				result.add("forward");
				i++;
			}else if(command.contains("두")) {
				for(int j = 0 ; j < 2; j++) {
					result.add("forward");
				}
				i++;
			}else if(command.contains("세")) {
				for(int j = 0 ; j < 3; j++) {
					result.add("forward");
				}
				i++;
			}else if(command.contains("네") || command.contains("내")) {
				for(int j = 0 ; j < 4; j++) {
					result.add("forward");
				}
				i++;
			}else if(command.contains("다섯")) {
				for(int j = 0 ; j < 5; j++) {
					result.add("forward");
				}
				i++;
			}else if(command.contains("여섯")) {
				for(int j = 0 ; j < 6; j++) {
					result.add("forward");
				}
				i++;
			}else if(command.contains("일곱")) {
				for(int j = 0 ; j < 7; j++) {
					result.add("forward");
				}
				i++;
			}else if(command.contains("여덜") || command.contains("여덟")) {
				for(int j = 0 ; j < 8; j++) {
					result.add("forward");
				}
				i++;
			}else if(command.contains("아홉")) {
				for(int j = 0 ; j < 9; j++) {
					result.add("forward");
				}
				i++;
			}
		}
		return result;
	}
	
}
