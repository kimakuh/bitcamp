-- �Խ���
DROP TABLE IF EXISTS pms2_board RESTRICT;

-- ȸ��
DROP TABLE IF EXISTS pms2_member RESTRICT;

-- ��
DROP TABLE IF EXISTS pms2_team RESTRICT;

-- ����
DROP TABLE IF EXISTS pms2_classroom RESTRICT;

-- �۾�
DROP TABLE IF EXISTS pms2_task RESTRICT;

-- ��ȸ��
DROP TABLE IF EXISTS pms2_team_member RESTRICT;

-- �Խ���
CREATE TABLE pms2_board (
	bno  INT          NOT NULL COMMENT '��ȣ', -- ��ȣ
	titl VARCHAR(255) NOT NULL COMMENT '����', -- ����
	cont TEXT         NULL     COMMENT '����', -- ����
	cdt  DATETIME     NOT NULL COMMENT '�����' -- �����
)
COMMENT '�Խ���';

-- �Խ���
ALTER TABLE pms2_board
	ADD CONSTRAINT PK_pms2_board -- �Խ��� �⺻Ű
		PRIMARY KEY (
			bno -- ��ȣ
		);

ALTER TABLE pms2_board
	MODIFY COLUMN bno INT NOT NULL AUTO_INCREMENT COMMENT '��ȣ';

-- ȸ��
CREATE TABLE pms2_member (
	mid   VARCHAR(20)  NOT NULL COMMENT '���̵�', -- ���̵�
	email VARCHAR(255) NOT NULL COMMENT '�̸���', -- �̸���
	pwd   VARCHAR(100) NOT NULL COMMENT '��ȣ' -- ��ȣ
)
COMMENT 'ȸ��';

-- ȸ��
ALTER TABLE pms2_member
	ADD CONSTRAINT PK_pms2_member -- ȸ�� �⺻Ű
		PRIMARY KEY (
			mid -- ���̵�
		);

-- ��
CREATE TABLE pms2_team (
	name    VARCHAR(100) NOT NULL COMMENT '�̸�', -- �̸�
	dscrt   TEXT         NULL     COMMENT '����', -- ����
	max_pty INT          NOT NULL COMMENT '�ִ��ο�', -- �ִ��ο�
	sdt     DATETIME     NOT NULL COMMENT '������', -- ������
	edt     DATETIME     NOT NULL COMMENT '������' -- ������
)
COMMENT '��';

-- ��
ALTER TABLE pms2_team
	ADD CONSTRAINT PK_pms2_team -- �� �⺻Ű
		PRIMARY KEY (
			name -- �̸�
		);

-- ����
CREATE TABLE pms2_classroom (
	crno INT          NOT NULL COMMENT '��ȣ', -- ��ȣ
	titl VARCHAR(255) NOT NULL COMMENT '������', -- ������
	sdt  DATETIME     NOT NULL COMMENT '������', -- ������
	edt  DATETIME     NOT NULL COMMENT '������', -- ������
	room VARCHAR(50)  NULL     COMMENT '����' -- ����
)
COMMENT '����';

-- ����
ALTER TABLE pms2_classroom
	ADD CONSTRAINT PK_pms2_classroom -- ���� �⺻Ű
		PRIMARY KEY (
			crno -- ��ȣ
		);

ALTER TABLE pms2_classroom
	MODIFY COLUMN crno INT NOT NULL AUTO_INCREMENT COMMENT '��ȣ';

-- �۾�
CREATE TABLE pms2_task (
	tano INT          NOT NULL COMMENT '��ȣ', -- ��ȣ
	titl VARCHAR(255) NOT NULL COMMENT '�۾���', -- �۾���
	sdt  DATETIME     NOT NULL COMMENT '������', -- ������
	edt  DATETIME     NOT NULL COMMENT '������', -- ������
	stat INT          NULL     COMMENT '����', -- ����
	mid  VARCHAR(20)  NOT NULL COMMENT '�۾���', -- �۾���
	tnm  VARCHAR(100) NOT NULL COMMENT '����' -- ����
)
COMMENT '�۾�';

-- �۾�
ALTER TABLE pms2_task
	ADD CONSTRAINT PK_pms2_task -- �۾� �⺻Ű
		PRIMARY KEY (
			tano -- ��ȣ
		);

ALTER TABLE pms2_task
	MODIFY COLUMN tano INT NOT NULL AUTO_INCREMENT COMMENT '��ȣ';

-- ��ȸ��
CREATE TABLE pms2_team_member (
	tnm VARCHAR(100) NOT NULL COMMENT '����', -- ����
	mid VARCHAR(20)  NOT NULL COMMENT '���̵�' -- ���̵�
)
COMMENT '��ȸ��';

-- ��ȸ��
ALTER TABLE pms2_team_member
	ADD CONSTRAINT PK_pms2_team_member -- ��ȸ�� �⺻Ű
		PRIMARY KEY (
			tnm, -- ����
			mid  -- ���̵�
		);

-- �۾�
ALTER TABLE pms2_task
	ADD CONSTRAINT FK_pms2_member_TO_pms2_task -- ȸ�� -> �۾�
		FOREIGN KEY (
			mid -- �۾���
		)
		REFERENCES pms2_member ( -- ȸ��
			mid -- ���̵�
		);

-- �۾�
ALTER TABLE pms2_task
	ADD CONSTRAINT FK_pms2_team_TO_pms2_task -- �� -> �۾�
		FOREIGN KEY (
			tnm -- ����
		)
		REFERENCES pms2_team ( -- ��
			name -- �̸�
		);

-- ��ȸ��
ALTER TABLE pms2_team_member
	ADD CONSTRAINT FK_pms2_team_TO_pms2_team_member -- �� -> ��ȸ��
		FOREIGN KEY (
			tnm -- ����
		)
		REFERENCES pms2_team ( -- ��
			name -- �̸�
		);

-- ��ȸ��
ALTER TABLE pms2_team_member
	ADD CONSTRAINT FK_pms2_member_TO_pms2_team_member -- ȸ�� -> ��ȸ��
		FOREIGN KEY (
			mid -- ���̵�
		)
		REFERENCES pms2_member ( -- ȸ��
			mid -- ���̵�
		);