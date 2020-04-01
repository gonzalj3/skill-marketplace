import React from 'react';
import styled from 'styled-components/macro';
import { Formik, Form } from 'formik';

const StyledForm = styled(Form)`
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-rows: repeat(4, minmax(40px, 1fr));
  align-items: center;
  justify-content: flex-start;
  padding: 2rem 5rem;
  border-bottom: 1px solid ${p => p.theme.changeOpacity('#cccccc', 50)};
`;

const SubsectionTitle = styled.h2`
  grid-row: 1;
  grid-column: 1/3;
`;

function ProfileSubsection({ children, title, ...props }) {
  return (
    <Formik {...props}>
      <StyledForm>
        <SubsectionTitle>{title}</SubsectionTitle>
        {children}
      </StyledForm>
    </Formik>
  );
}

export default ProfileSubsection;
