 #4
select *
from paper P, writes W, author A
where A.AuthorName="Damian" 
	AND A.Email=W.Email
    AND W.PaperID = P.PaperID
	AND W.PaperID IN(select W.PaperID
		from Writes W
		Group By W.PaperID
		having count(W.Email)=1);

#5
select P.PaperID, P.Title, A.AuthorName
from paper P, writes W, author A
where A.AuthorName="Dan" 
	AND A.Email=W.Email 
    AND W.PaperID=P.PaperID 
    AND W.AuthorOrder=1;

#6 NOT DONE
select distinct *
from paper P, author A1, author A2, writes W1, writes W2
where P.PaperID=W1.PaperID
	AND A1.AuthorName="Dan"
    AND A2.AuthorName="Don"
    AND A1.email=W1.email
    AND A2.email=W2.email;

#7
select * from PCMember
where email in(
select email
from review
group by email
having count(*) = (
select max(X.num)
from
        (select email, count(*) as num
        from review
        group by email) AS X));


#8
select *
from pcmember
where Email NOT IN
	(select Email
    from review);

#9
select *
from review R1,review R2, paper P, pcmember PC1, pcmember PC2
where R1.Recommend="F"
	AND R2.Recommend="F"
    AND PC1.MemberName="Jacob"
    AND PC2.MemberName="Joseph"
    AND R1.PaperID=R2.PaperID
    AND R1.Email=PC1.Email
    AND R2.Email=PC2.Email
    AND P.PaperID=R1.PaperID;

#10    
CREATE VIEW recommended_papers AS 
Select * 
from paper
Where paperID IN
(select P.paperID
from paper P, review R
Where R.Recommend='T'
	AND P.paperID=R.PaperID
Group by P.paperID
having count(*)>1)

#All people who wrote paper
Select *
From paper P, writes W, author A
Where P.PaperID=2
	AND P.PaperID=W.PaperID
    AND W.email=A.email
	Order by W.authorOrder asc;
