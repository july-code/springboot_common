select * from staff_position where uuid in (select max(uuid) from staff_position group by department) and country = '美国'

insert into psy_research(uuid,country,type,method,lasttime)
values('','美国','理论','政治心理战、经济心理战、外交心理战、文化心理战、心理学原理',now()),
('','美国','技术','传统心理战手段：战地广播、高音喇叭、传单、漂流瓶、热气球',now()),
('','美国','装备','高新技术：卫星定位测向、电视转播技术、计算机信息处理技术、网络技术、信号模拟、失真技术、声像技术、语言模拟技术、虚拟现实技术、激光技术、现代仿声、仿形技术和隐形技术',now())


