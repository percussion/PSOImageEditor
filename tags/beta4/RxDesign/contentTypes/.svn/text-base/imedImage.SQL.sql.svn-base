CREATE TABLE  "CT_IMEDIMAGE" 
   (	"CONTENTID" int, 
	"REVISIONID" int, 
	"ALT" [nvarchar](255), 
	"IMG" [image], 
	"IMG_TYPE" [nvarchar](100), 
	"IMG_FILENAME" [nvarchar](200), 
	"IMG_EXT" [nvarchar](50), 
	"IMG_SIZE" [nvarchar](50), 
	"IMG_HEIGHT" [nvarchar](50), 
	"IMG_WIDTH" [nvarchar](50), 
	 CONSTRAINT "PK_CT_IMEDIMAGE" PRIMARY KEY ("CONTENTID", "REVISIONID")
   )

CREATE TABLE  "CT_IMEDIMAGE_SIZED" 
   (	"CONTENTID" int, 
	"REVISIONID" int, 
	"SYSID" int, 
	"SORTRANK" int, 
	"SIZE_CODE" [nvarchar](50), 
	"SIZED_IMG" [image], 
	"SIZED_IMG_TYPE" [nvarchar](200), 
	"SIZED_IMG_FILENAME" [nvarchar](200), 
	"SIZED_IMG_EXT" [nvarchar](50), 
	"SIZED_IMG_HEIGHT" [nvarchar](50), 
	"SIZED_IMG_WIDTH" [nvarchar](50), 
	"SIZED_IMG_SIZE" [nvarchar](50), 
	 CONSTRAINT "PK_CT_IMEDIMAGE_SIZED" PRIMARY KEY ("CONTENTID", "REVISIONID", "SYSID")
   )