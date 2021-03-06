package k07.flashcards.utils;

import java.util.*;

public class SupportedCharacterList {
    private static Random random = new Random();

    private static char[] grade0 = {'了', '与', '々', '乏', '互', '介', '冗', '匹', '双', '巨', '占', '召', '込', '払', '甘', '企', '伏', '充', '叫', '芝', '汚', '汗', '忙', '肌', '缶', '舟', '伸', '伺', '即', '含', '吹', '坊', '床', '迎', '沈', '沢', '抜', '抑', '抗', '狂', '戻', '攻', '更', '辛', '依', '侮', '免', '刺', '到', '卓', '姓', '彼', '征', '邪', '況', '泥', '泊', '沸', '押', '抱', '抵', '怖', '怪', '昇', '肯', '肩', '杯', '欧', '祈', '突', '咲', '封', '荒', '逃', '郊', '挟', '狭', '怒', '柔', '枯', '珍', '皆', '冒', '香', '倒', '凍', '哲', '埋', '娘', '華', '途', '浮', '涙', '捜', '捕', '悩', '悟', '恋', '恥', '恐', '脂', '畜', '疲', '眠', '般', '軒', '辱', '隻', '乾', '偶', '偏', '婚', '菓', '涼', '渉', '掛', '掘', '掃', '描', '控', '猫', '患', '脱', '瓶', '盗', '符', '粒', '紹', '袋', '豚', '販', '軟', '頃', '鹿', '偉', '募', '喫', '堅', '塔', '奥', '幅', '帽', '幾', '弾', '御', '遅', '隅', '湿', '湾', '渡', '換', '敢', '替', '普', '腕', '焦', '畳', '硬', '筒', '絡', '超', '越', '鈍', '雇', '傾', '勧', '塗', '奨', '嫌', '寝', '違', '溶', '暇', '腰', '歳', '殿', '煙', '触', '詰', '詳', '誇', '跡', '較', '零', '靴', '飽', '僕', '滴', '憎', '概', '稲', '端', '緒', '踊', '髪', '寮', '影', '膚', '範', '緊', '誰', '趣', '輩', '舞', '鋭', '震', '駐', '壊', '薄', '避', '隣', '濃', '曇', '磨', '賢', '頼', '濯', '燥', '療', '齢', '礎', '穫', '贈', '離', '騒', '爆', '籍', '響', '驚'};
    private static char[] grade1 = {'一', '七', '九', '二', '人', '入', '八', '力', '十', '上', '下', '三', '千', '口', '土', '夕', '大', '女', '子', '小', '山', '川', '中', '五', '六', '円', '天', '手', '文', '日', '月', '木', '水', '火', '犬', '王', '出', '右', '四', '左', '本', '正', '玉', '生', '田', '白', '目', '石', '立', '休', '先', '名', '字', '年', '早', '気', '百', '竹', '糸', '耳', '虫', '花', '村', '男', '町', '見', '貝', '赤', '足', '車', '学', '林', '空', '金', '雨', '青', '草', '音', '校', '森'};
    private static char[] grade2 = {'刀', '万', '丸', '工', '弓', '才', '今', '元', '公', '内', '切', '分', '午', '友', '太', '少', '引', '心', '戸', '方', '止', '毛', '父', '牛', '兄', '冬', '北', '半', '台', '古', '外', '市', '広', '母', '用', '矢', '交', '会', '光', '同', '合', '回', '地', '多', '寺', '当', '池', '毎', '考', '米', '羽', '肉', '自', '色', '行', '西', '何', '体', '作', '図', '声', '売', '弟', '形', '近', '汽', '来', '社', '角', '言', '谷', '走', '里', '麦', '京', '画', '国', '夜', '姉', '妹', '岩', '店', '明', '東', '歩', '直', '知', '長', '門', '前', '南', '室', '後', '茶', '活', '海', '思', '春', '昼', '星', '点', '秋', '科', '計', '風', '食', '首', '原', '夏', '家', '帰', '弱', '通', '書', '時', '紙', '記', '馬', '高', '強', '週', '教', '理', '組', '細', '船', '野', '雪', '魚', '鳥', '黄', '黒', '場', '道', '晴', '朝', '番', '答', '絵', '買', '間', '雲', '園', '遠', '数', '新', '楽', '話', '電', '歌', '算', '読', '語', '聞', '鳴', '線', '親', '頭', '曜', '顔'};
    private static char[] grade3 = {'予', '化', '区', '反', '世', '主', '仕', '他', '代', '写', '去', '号', '央', '平', '打', '氷', '礼', '由', '申', '皮', '皿', '両', '全', '列', '向', '守', '安', '州', '式', '曲', '有', '次', '死', '羊', '血', '住', '助', '医', '君', '坂', '対', '局', '役', '返', '決', '投', '究', '豆', '身', '事', '使', '具', '取', '受', '命', '和', '味', '委', '始', '実', '定', '岸', '幸', '苦', '注', '泳', '油', '波', '所', '放', '昔', '服', '育', '板', '物', '者', '表', '乗', '係', '品', '客', '屋', '度', '待', '送', '追', '洋', '持', '拾', '指', '急', '昭', '相', '柱', '炭', '神', '界', '畑', '発', '県', '研', '秒', '級', '美', '負', '重', '面', '倍', '勉', '員', '宮', '島', '庭', '庫', '荷', '速', '院', '流', '消', '息', '旅', '根', '病', '真', '起', '配', '酒', '動', '商', '宿', '帳', '進', '部', '都', '深', '悪', '族', '球', '祭', '章', '第', '笛', '終', '習', '転', '問', '勝', '寒', '落', '葉', '運', '遊', '階', '陽', '温', '湯', '湖', '港', '悲', '暑', '期', '植', '登', '着', '短', '童', '等', '筆', '軽', '開', '集', '飲', '歯', '漢', '意', '感', '想', '暗', '業', '福', '詩', '路', '農', '鉄', '様', '練', '緑', '銀', '駅', '鼻', '横', '箱', '調', '談', '薬', '整', '橋', '館', '題'};
    private static char[] grade4 = {'士', '不', '夫', '欠', '氏', '以', '付', '令', '功', '加', '包', '史', '司', '失', '辺', '必', '未', '末', '札', '民', '争', '伝', '仲', '兆', '共', '印', '各', '好', '成', '灯', '老', '衣', '低', '位', '児', '兵', '冷', '初', '別', '利', '努', '労', '告', '囲', '完', '希', '芸', '折', '改', '束', '材', '求', '良', '臣', '例', '典', '刷', '卒', '協', '参', '周', '固', '季', '官', '府', '底', '径', '英', '芽', '治', '法', '泣', '念', '果', '松', '毒', '牧', '的', '信', '便', '勇', '型', '変', '建', '単', '浅', '昨', '胃', '栄', '祝', '省', '約', '紀', '要', '軍', '飛', '借', '候', '倉', '孫', '害', '差', '席', '帯', '徒', '連', '郡', '浴', '挙', '料', '脈', '案', '梅', '残', '殺', '特', '笑', '粉', '航', '訓', '側', '停', '健', '副', '唱', '堂', '巣', '康', '得', '菜', '陸', '清', '敗', '救', '望', '械', '産', '票', '貨', '博', '喜', '達', '隊', '満', '散', '最', '景', '焼', '無', '然', '結', '給', '街', '覚', '象', '費', '貯', '量', '順', '飯', '働', '塩', '愛', '戦', '腸', '極', '照', '置', '節', '続', '試', '辞', '察', '漁', '旗', '歴', '種', '管', '説', '関', '静', '億', '器', '選', '標', '熱', '課', '賞', '輪', '養', '機', '積', '録', '観', '類', '験', '鏡', '願', '競', '議'};
    private static char[] grade5 = {'久', '仏', '支', '比', '刊', '可', '句', '圧', '布', '弁', '犯', '旧', '永', '示', '件', '任', '仮', '再', '団', '因', '在', '舌', '似', '余', '判', '均', '序', '防', '技', '快', '応', '志', '条', '災', '状', '価', '舎', '券', '制', '効', '妻', '居', '往', '述', '河', '招', '性', '承', '易', '肥', '枝', '武', '版', '非', '保', '則', '厚', '退', '逆', '迷', '限', '独', '故', '政', '査', '祖', '俵', '修', '個', '容', '師', '造', '恩', '能', '桜', '格', '留', '益', '破', '素', '耕', '財', '務', '基', '婦', '寄', '常', '張', '険', '混', '液', '授', '接', '採', '情', '断', '現', '率', '略', '眼', '移', '経', '術', '規', '許', '設', '貧', '責', '備', '報', '富', '属', '復', '過', '営', '測', '減', '提', '検', '税', '程', '統', '絶', '証', '評', '貿', '貸', '賀', '勢', '墓', '夢', '幹', '準', '損', '罪', '禁', '義', '群', '解', '豊', '資', '鉱', '預', '飼', '像', '増', '境', '徳', '適', '際', '演', '慣', '態', '構', '複', '精', '綿', '総', '製', '酸', '銭', '銅', '雑', '領', '導', '潔', '敵', '暴', '確', '編', '質', '賛', '燃', '築', '興', '衛', '輸', '績', '講', '謝', '織', '職', '額', '識', '護'};
    private static char[] grade6 = {'亡', '寸', '己', '干', '仁', '収', '尺', '片', '冊', '処', '幼', '庁', '穴', '危', '灰', '后', '吸', '存', '宇', '宅', '机', '至', '乱', '卵', '否', '困', '孝', '批', '忘', '我', '私', '系', '並', '乳', '供', '刻', '呼', '垂', '宗', '宙', '宝', '届', '延', '若', '沿', '拝', '担', '拡', '忠', '枚', '城', '奏', '姿', '宣', '専', '巻', '律', '洗', '派', '映', '肺', '背', '染', '段', '泉', '皇', '看', '砂', '紅', '革', '俳', '値', '党', '将', '射', '展', '座', '従', '陛', '降', '除', '朗', '胸', '株', '班', '秘', '納', '純', '蚕', '討', '針', '骨', '域', '密', '著', '郷', '郵', '済', '探', '捨', '推', '脳', '欲', '異', '盛', '窓', '翌', '視', '訳', '訪', '閉', '頂', '割', '創', '勤', '善', '尊', '就', '揮', '敬', '晩', '棒', '痛', '補', '策', '筋', '衆', '裁', '装', '詞', '貴', '傷', '幕', '蒸', '源', '暖', '腹', '盟', '署', '絹', '聖', '裏', '誠', '賃', '層', '障', '暮', '模', '疑', '磁', '穀', '誌', '誤', '認', '閣', '劇', '蔵', '遺', '潮', '権', '熟', '諸', '誕', '論', '奮', '激', '操', '憲', '樹', '糖', '縦', '鋼', '優', '厳', '縮', '覧', '簡', '臨', '難', '臓', '警'};

    private static List<Character> allCharacters = new ArrayList<>();
    private static HashMap<Integer, char[]> gradeMap = new HashMap<>();
    static {
        gradeMap.put(0, grade0);
        gradeMap.put(1, grade1);
        gradeMap.put(2, grade2);
        gradeMap.put(3, grade3);
        gradeMap.put(4, grade4);
        gradeMap.put(5, grade5);
        gradeMap.put(6, grade6);

        for(char[] chars: gradeMap.values()) {
            for(char current: chars) {
                allCharacters.add(current);
            }
        }
    }

    public static char getRandomCharacterByGrade(int grade) {
        char[] characters = gradeMap.get(grade);
        return characters[random.nextInt(characters.length)];
    }

    public static char getRandomCharacter() {
        return allCharacters.get(random.nextInt(allCharacters.size()));
    }

}
