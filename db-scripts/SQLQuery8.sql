USE [tools-rental]
GO
/****** Object:  Table [dbo].[Borrowing]    Script Date: 27.10.2020 19:39:19 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Borrowing]') AND type in (N'U'))
DROP TABLE [dbo].[Borrowing]
GO

/****** Object:  Table [dbo].[user_roles]    Script Date: 27.10.2020 19:38:55 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[user_roles]') AND type in (N'U'))
DROP TABLE [dbo].[user_roles]
GO

/****** Object:  Table [dbo].[Product]    Script Date: 27.10.2020 19:38:14 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Product]') AND type in (N'U'))
DROP TABLE [dbo].[Product]
GO

/****** Object:  Table [dbo].[Category]    Script Date: 27.10.2020 19:37:55 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Category]') AND type in (N'U'))
DROP TABLE [dbo].[Category]
GO

/****** Object:  Table [dbo].[role]    Script Date: 27.10.2020 19:37:09 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[role]') AND type in (N'U'))
DROP TABLE [dbo].[role]
GO

/****** Object:  Table [dbo].[app_user]    Script Date: 27.10.2020 19:37:39 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[app_user]') AND type in (N'U'))
DROP TABLE [dbo].[app_user]
GO

/****** Object:  Table [dbo].[role]    Script Date: 27.10.2020 19:37:09 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[role](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[creation_date] [datetime2](7) NOT NULL,
	[last_update] [datetime2](7) NULL,
	[description] [varchar](255) NULL,
	[name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Borrowing](
	[SinceDate] [datetime] NOT NULL,
	[ToDate] [datetime] NULL,
	[Id] [bigint] IDENTITY(1,1) NOT NULL,
	[IdProduct] [bigint] NOT NULL,
	[IdEmployee] [bigint] NULL,
	[IdClient] [bigint] NOT NULL,
	[Amount] [int] NOT NULL,
 CONSTRAINT [PK_Borrowing] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[app_user](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[creation_date] [datetime2](7) NOT NULL,
	[last_update] [datetime2](7) NULL,
	[email] [varchar](255) NULL,
	[first_name] [varchar](255) NULL,
	[last_name] [varchar](255) NULL,
	[password] [varchar](255) NULL,
	[phone] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [UK1j9d9a06i600gd43uu3km82jw] UNIQUE NONCLUSTERED 
(
	[email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Product](
	[Cost] [float] NOT NULL,
	[Id] [bigint] IDENTITY(1,1) NOT NULL,
	[Picture] [nvarchar](50) NULL,
	[Description] [nvarchar](max) NULL,
	[MaxPieces] [int] NULL,
	[AvailablePieces] [int] NOT NULL,
	[IdCategory] [bigint] NOT NULL,
 CONSTRAINT [PK_Product] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

CREATE TABLE [dbo].[Category](
	[Id] [bigint] IDENTITY(1,1) NOT NULL,
	[Description] [nvarchar](max) NULL,
	[Name] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

CREATE TABLE [dbo].[user_roles](
	[user_id] [bigint] NOT NULL,
	[role_id] [bigint] NOT NULL,
	[Id] [bigint] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_user_roles] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO


ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_Category] FOREIGN KEY([IdCategory])
REFERENCES [dbo].[Category] ([Id])
GO

ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_Category]
GO

ALTER TABLE [dbo].[user_roles]  WITH CHECK ADD  CONSTRAINT [FK6fql8djp64yp4q9b3qeyhr82b] FOREIGN KEY([user_id])
REFERENCES [dbo].[app_user] ([id])
GO

ALTER TABLE [dbo].[user_roles] CHECK CONSTRAINT [FK6fql8djp64yp4q9b3qeyhr82b]
GO

ALTER TABLE [dbo].[user_roles]  WITH CHECK ADD  CONSTRAINT [FKrhfovtciq1l558cw6udg0h0d3] FOREIGN KEY([role_id])
REFERENCES [dbo].[role] ([id])
GO

ALTER TABLE [dbo].[user_roles] CHECK CONSTRAINT [FKrhfovtciq1l558cw6udg0h0d3]
GO

ALTER TABLE [dbo].[Borrowing] ADD  CONSTRAINT [DF_Borrowing_IdEmployee]  DEFAULT ((0)) FOR [IdEmployee]
GO

ALTER TABLE [dbo].[Borrowing]  WITH CHECK ADD  CONSTRAINT [FK_Borrowing_Product] FOREIGN KEY([IdProduct])
REFERENCES [dbo].[Product] ([Id])
GO

ALTER TABLE [dbo].[Borrowing] CHECK CONSTRAINT [FK_Borrowing_Product]
GO

ALTER TABLE [dbo].[Borrowing]  WITH CHECK ADD  CONSTRAINT [FK_Borrowing_user_roles] FOREIGN KEY([IdClient])
REFERENCES [dbo].[user_roles] ([Id])
GO

ALTER TABLE [dbo].[Borrowing] CHECK CONSTRAINT [FK_Borrowing_user_roles]
GO

ALTER TABLE [dbo].[Borrowing]  WITH CHECK ADD  CONSTRAINT [FK_Borrowing_user_roles1] FOREIGN KEY([IdEmployee])
REFERENCES [dbo].[user_roles] ([Id])
GO

ALTER TABLE [dbo].[Borrowing] CHECK CONSTRAINT [FK_Borrowing_user_roles1]
GO

